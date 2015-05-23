public class Solution {
    // P[i][j] : s.substring from s[i] to s[j] is a palindrome
    // P[i][j] = true if P[i+1][j-1] AND s.charAt(i) == s.charAt(j)
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        boolean P[][] = new boolean [n][n];
        int max_len = 1;
        int start = 0;
        for(int j=0; j<n; j++){
            for(int i=j; i>=0; i--){ // mistake : i=n-1 is wrong
                // mistake : forgot j-i<=1 && s[i]==s[j]
                P[i][j] =  ((j-i<=1 || P[i+1][j-1])  && s.charAt(i)==s.charAt(j)); 
                if(P[i][j] && max_len < j-i+1){
                    max_len = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start+max_len);
    }
}
