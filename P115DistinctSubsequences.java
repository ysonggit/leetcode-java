public class Solution {
    // D[i][j]: number of distinct subseq 
    // given the first i chars of s and first j chars of t
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int D[][] = new int[m+1][n+1];
        for(int i=0; i<=m; i++) D[i][0] = 1;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                D[i][j] = (s.charAt(i-1)==t.charAt(j-1)) ? D[i-1][j-1] + D[i-1][j] : D[i-1][j];
            }
        }
        return D[m][n];
    }
}
