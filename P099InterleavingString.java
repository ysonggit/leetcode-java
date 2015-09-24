public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m+n!= s3.length()) return false;
        if(m==0) return s3.equals(s2);
        if(n==0) return s3.equals(s1);
        boolean D[][] = new boolean[m+1][n+1];
        D[0][0] = true;
        for(int i=1; i<=m; i++){
            D[i][0] = (D[i-1][0] && s3.charAt(i-1)==s1.charAt(i-1)) ? true : false;
        }
        for(int j=1; j<=n; j++){
            D[0][j] = (D[0][j-1] && s3.charAt(j-1)==s2.charAt(j-1)) ? true :false;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int k=i+j-1;
                D[i][j] = (D[i][j-1] && s3.charAt(k)==s2.charAt(j-1)) 
                        || (D[i-1][j] && s3.charAt(k)==s1.charAt(i-1));
            }
        }
        return D[m][n];
    }
}
