public class Solution {
    /* DP
     * D[i] : is true if first i characters in s can be segmented into words
     * D[0] = true
     * D[i] = D[k] && s[k, i-1] is in dictionary
     */
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        if(n==0) return true;
        boolean D[] = new boolean [n+1];
        D[0] = true;
        for(int i=1; i<=n; i++){
            D[i] = false;
            for(int k=i-1; k>=0; k--){
                if(wordDict.contains(s.substring(k, i)) && D[k]==true){
                    D[i] = true;
                    break;
                }
            }
        }
        return D[n];
    }
}
