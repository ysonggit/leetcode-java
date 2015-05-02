public class Solution {
    public int titleToNumber(String s) {
        int n = s.length();
        if(n==0) return 0;
        int res = 0;
        for(int i=0; i<n; i++){
            char cur = s.charAt(i);
            res = res * 26 + (cur - 'A' + 1);
        }
        return res;
    }
}
