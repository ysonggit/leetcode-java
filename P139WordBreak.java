public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean D[] = new boolean[n+1];
        D[0] = true;
        for(int i=1; i<=n; i++){
            for(int k=0; k<i; k++){
                String rest = s.substring(k, i);
                if(wordDict.contains(rest) && D[k]){
                    D[i] = true;
                    break;
                }
            }
        }
        return D[n];
    }
}
