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
