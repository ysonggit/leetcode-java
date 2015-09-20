public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int D[][] = new int[m+1][n+1];
        for(int i=1; i<=m; i++) D[i][0] = i;
        for(int j=0; j<=n; j++) D[0][j] = j;
        for(int i=1; i<=m; i++){
            char sc = word1.charAt(i-1);
            for(int j=1; j<=n; j++){
                char tc = word2.charAt(j-1);
                if(sc==tc){
                    D[i][j] = D[i-1][j-1];
                }else{
                    D[i][j] = 1 + Math.min(Math.min(D[i-1][j], D[i][j-1]), D[i-1][j-1]);
                }
            }
        }
        return D[m][n];
    }
}
