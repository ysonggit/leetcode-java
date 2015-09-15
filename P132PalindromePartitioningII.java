Enter file contents herepublic class Solution {
    /**
     * P[i][j]: s[i,..,j] is a palindrome
     * 
     * D[i]: minimum cuts needed for the characters s[0]..s[i]
     * D[i] = 0 if P[0][i] is true
     *      = min(D[j]) + 1 if s[j+1,..,i] is a palindrome for j in [0, i-1]
     * 
     */ 
    public int minCut(String s) {
        int n = s.length();
        if(n<2) return 0;
        boolean P[][] = new boolean [n][n];
        for(int i=0; i<n; i++){
            P[i][i] = true;
        }
        for(int len=2; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j= i+len-1;
                if(len==2){
                    P[i][j] = (s.charAt(i)==s.charAt(j)) ? true : false;
                }else{
                    if(s.charAt(i)==s.charAt(j) && P[i+1][j-1]){
                        P[i][j]=true;
                    }
                }
            }
        }
        int D[] = new int[n];
        for(int i=0; i<n; i++){
            if(P[0][i]) D[i] = 0;
            else{
                D[i] = n;
                for(int j=0; j<i; j++){
                    if(P[j+1][i]) { // mistake: P[j+1][i] not P[j][i]
                        D[i] = Math.min(D[i], D[j]+1);
                    }
                }
            }
        }
        return D[n-1];
    }
}
