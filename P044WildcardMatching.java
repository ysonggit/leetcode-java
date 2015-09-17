public class Solution {
      /**
     * '*' - any sequence including empty
     * D[i][j] : the first i characters in s match first j characters in p
     * initial
     * D[0][j] is true if p[j-1] =='*' && D[0][j-1]
     * if cur is not *
     * D[i][j] = D[i-1][j-1] && (s[j-1]==p[j-1] || p[j-1]==?)
     * if *
     * D[i][j] = true if D[i-1][j-1] is true, also D[i+1][j] ... D[n][j] = true
     *         = true if D[i][j-1] is true    s="aba|a" p="*a|*"
     */
    public boolean isMatch(String s, String p) {
        int n=s.length(), m= p.length();
        if(m==0) return (n==0) ? true : false;
        boolean D[][] = new boolean[n+1][m+1];
        D[0][0] = true;
        // initialize
        for(int j=1; j<=m; j++){
            if(p.charAt(j-1)=='*' && D[0][j-1]){
                D[0][j] = true;
            }
        }
        for(int i=1; i<=n; i++){
            char sc = s.charAt(i-1);
            for(int j=1; j<=m; j++){
                char pc = p.charAt(j-1);
                if(pc!='*'){
                    D[i][j] = (D[i-1][j-1] && (sc==pc || pc=='?')) ? true : false;
                }else{
                    if(D[i-1][j-1]){
                        for(int k=i; k<=n; k++) D[k][j] = true;
                    }else{
                        if(D[i][j-1]) D[i][j]= true;
                    }
                }
            }
        }
        return D[n][m];
    }
}
