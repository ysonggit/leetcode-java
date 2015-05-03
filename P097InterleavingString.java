public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if(n1+n2!=n3) return false;
        boolean D[][] = new boolean[n1+1][n2+1];
        D[0][0] = true;
        for(int i=1; i<=n1; i++){
            D[i][0] = s3.substring(0, i).equals(s1.substring(0, i)) ? true : false;
        }
        for(int i=1; i<=n2; i++){
            D[0][i] = s3.substring(0, i).equals(s2.substring(0, i)) ? true : false;
        }
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if((s3.charAt(i+j-1) == s1.charAt(i-1) && D[i-1][j] ) || (s3.charAt(i+j-1)==s2.charAt(j-1) && D[i][j-1])) D[i][j]=true;
                else D[i][j] = false;
            }
        }
        return D[n1][n2];
    }
}
