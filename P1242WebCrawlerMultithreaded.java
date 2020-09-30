class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);
        Set<String> visited = ConcurrentHashMap.newKeySet();
        visited.add(startUrl);
        return crawl(startUrl, htmlParser, hostname, visited).collect(Collectors.toList());
    }
    private Stream<String> crawl(String startUrl, HtmlParser htmlParser, String hostname, Set<String> visited) {
        Stream<String> stream = htmlParser.getUrls(startUrl)
            .parallelStream()
            .filter(url->isSameDomain(url, hostname))
            .filter(url->visited.add(url))
            .flatMap(url->crawl(url, htmlParser, hostname, visited));
        return Stream.concat(Stream.of(startUrl), stream);
    }
    
    private String getHostname(String url) {
        int idx = url.indexOf("/", 7); // http://abc.def ==> abc.def
        return (idx != -1) ? url.substring(0, idx) : url;
    }
    
    private boolean isSameDomain(String url, String hostname) {
        return getHostname(url).equalsIgnoreCase(hostname);
    }
}
