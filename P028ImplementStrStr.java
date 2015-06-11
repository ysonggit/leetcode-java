public class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if(m==0 && n==0) return 0; // mistake : "" "" return 0 not -1
        if(n<m) return -1;         
        for(int i=0; i<=n-m; i++){ // mistake : should be <= not < !
            int count = 0;
            for(int j=0; j<m; j++){
                if(needle.charAt(j) != haystack.charAt(i+j)) break;
                else count++;
            }
            if(count == m) return i;
        }
        return -1;
    }
}
public class Solution {
    /* KMP
       create prefix table T[j] means the length of the longest prefix of string P
       that is the suffix of P[i..j]
       Example:
        j    0 1 2 3 4 5
       P[j]  a b a c a b
       T[j]  0 0 1 0 1 2
       T[2] = 1 means the length of the longest prefix of string P ('a') is also the suffix of P[0..2] (aba)
        
        i   0 1 2 3 4 5 6 7 8 9
        S:	a b	a c	a a	b a	c c
        P:	a b	a c	a b
       mismatch at index 5 : S[5] != P[5]
        
       the steps of backtracking is T[j-1] = T[4] = 1 
       restart search from  P[T[j-1]], S[i]
       
        j   0 1 2 3 4 5 6 7 8 9
        S:	a b	a c	a a	b a	c c
        P:	    	a b a c a b
       
    */
    public void computePrefixTable(int []T, String P){
        T[0] = 0;
        int i = 0, j = 1;
        while(j<P.length()){
            if(P.charAt(i) == P.charAt(j)){
                i++;
                T[j] = i;
                j++;
            }else if(i > 0){
                // restore i
                i = T[i-1];
            }else{
                T[j]=0;
                j++;
            }
        }
    }
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(m==0 ) return 0;
        int []T = new int[m];
        computePrefixTable(T, needle);
        int i=0, j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                if(j==m-1) return i-j;
                i++;
                j++;
            }else if(j>0){
                j = T[j-1];
            }else{
                i++;
            }
        }
        return -1;
    }
}
