public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        if(n==0) return 0;
        int shortest_distance = n;
        int idx1 = -1, idx2 = -1;
        for(int i=0; i<n; i++){
            String cur = words[i];
            if(cur.equals(word1)){ // mistake: using == is wrong
                idx1=i;
            }
            if(cur.equals(word2)){
                idx2=i;
            }
            if(idx1>=0 && idx2>=0){
                shortest_distance = Math.min(shortest_distance, Math.abs(idx2-idx1));
            }
        }
        return shortest_distance;
    }
}
