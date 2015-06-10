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
       create failure function, table T[i] means
       the steps of backtracking if needle[i] != haystack[m+i],  
       restart search from needle [T[i]], haystack[m+i-T[i]]
    */
    public void computeFailureFunction(int []T, String W){
        T[0] = -1;
        T[1] = 0;
        int idx = 0, pos = 2;
        while(pos<W.length()){
            if(W.charAt(idx) == W.charAt(pos-1)){
                idx++;
                T[pos] = idx;
                pos++;
            }else if(idx > 0){
                // restore idx
                idx = T[idx];
            }else{
                T[pos]=0;
                pos++;
            }
        }
    }
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        if(n==0 ) return 0;
        if(n==1) return haystack.indexOf(needle.charAt(0));
        int []T = new int[n];
        computeFailureFunction(T, needle);
        int m=0, i=0;
        while(m+i<haystack.length()){
            if(haystack.charAt(m+i) == needle.charAt(i)){
                i++;
                if(i==n) return m;
            }else{
                if(T[i]>-1){
                    m=m+i-T[i];
                    i=T[i];
                }else{
                    m++;
                    i=0;
                }
            }
        }
        return -1;
    }
}
