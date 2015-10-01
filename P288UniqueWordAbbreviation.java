public class ValidWordAbbr {
    Map<String, List<String>> wordLists = new HashMap<String, List<String>>();
    public ValidWordAbbr(String[] dictionary) {
        for(String wd : dictionary){
            if(wd.length()==0) continue;
            String key = compressWord(wd);
            if(!wordLists.containsKey(key)){
                List<String> list = new ArrayList<String>();
                wordLists.put(key, list);
            }
            wordLists.get(key).add(wd);
        }
    }
    public String compressWord(String word){
        int n = word.length();
        if(n<=2) return word;
        return word.substring(0,1)+String.valueOf(n-2)+word.substring(n-1);
    }
    public boolean isUnique(String word) {
        String key = compressWord(word);
        if(!wordLists.containsKey(key) ) return true;
        if(wordLists.get(key).size()>1) return false;
        return wordLists.get(key).get(0).equals(word);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
