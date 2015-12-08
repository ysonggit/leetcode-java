public class WordDistance {
    Map<String, ArrayList<Integer>> word_pos;
    public WordDistance(String[] words) {
        word_pos = new HashMap<String, ArrayList<Integer>>();
        for(int i=0; i<words.length; i++){
            String wd = words[i];
            if(!word_pos.containsKey(wd)) word_pos.put(wd, new ArrayList<Integer>());
            word_pos.get(wd).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        for(int pos1 : word_pos.get(word1)){
            for(int pos2 : word_pos.get(word2)){
                dist = Math.min(dist, Math.abs(pos1-pos2));
            }
        }
        return dist;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
