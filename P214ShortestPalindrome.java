public class Solution1 {
    // KMP compute prefix table T[0] means the length of the longest
    // prefix of s that is also the suffix of s[0...j]
    // see strstr
    public void computePrefixTable(int[] T, String s){
        T[0] =0;
        int i=0, j=1;
        while(j<s.length()){
            if(s.charAt(i) == s.charAt(j)){
                T[j] = i+1;
                i++;
                j++;
            }else if(i>0){
                i=T[i-1]; // restore i
            }else{
                T[j] = 0;
                j++;
            }
        }
    }
    /* http://blog.csdn.net/pointbreak1/article/details/45931551
       1. reverse string -> rev
       2. concat p=s+rev
       3. find prefix table T of p using KMP
       4. return rev.substring(0, N-T[2N-1])+s  (N is length of s)
       Example s="abbacd"
       rev="dcabba" => 
       p : a b b a c d d c a b b a
       T : 0 0 0 1 0 0 0 0 1 2 3 4
                      |---|
                        |___ substring we need to prepend to original one
    */
    public String shortestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        String rev = new StringBuilder(s).reverse().toString();
        String p = s+rev;
        int [] T = new int [2*n];
        computePrefixTable(T, p);
        // length of the longest prefix of p that is also the suffix of p
        int len_longest_prefix = T[2*n-1];
        return rev.substring(0, n-len_longest_prefix)+s;
    }
}

public class Solution2 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        // find the first index that makes s non-palindrome
        int j = 0;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(j)==s.charAt(i)){
                j++;
            }
        }
        if(j==n) return s; // s is a palindrom already
        String suffix = s.substring(j);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = s.substring(0, j);
        return prefix + shortestPalindrome(mid) + suffix;
    }
}
