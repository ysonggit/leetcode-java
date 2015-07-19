public class Solution {
    /*
      Similar to fibnacci
      fn = fn_1 + fn_2
      given string s[0,m-1], define fn as the number of ways decoding the first n bits of s (s[0..n-1])
      then fn = fn_1 * (s[n-1]==1) + fn_2 * (s[n-2]==1 || (s[n-2]==2 && s[n-1]<=7))
      
    */
    public int numDecodings(String s) {
        int m = s.length();
        if(m==0) return 0;
        if(s.charAt(0) == '0') return 0; // mistake:  special cases "01" "0"
        int fn_1 = 1, fn_2 = 1, fn = 1;
        for(int n=2; n<=m; n++){
            char cur = s.charAt(n-1);
            char pre = s.charAt(n-2);
            int decodable_one = (cur !='0') ? 1 : 0;
            int decodable_two = (pre == '1' || (pre=='2' && cur < '7')) ? 1: 0;
            fn = fn_1 * decodable_one + fn_2 * decodable_two;
            fn_2 = fn_1;
            fn_1 = fn;
        }
        return fn;
    }
}
