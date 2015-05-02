public class Solution {
    public int reverse(int x) {
        if(x==0) return 0;
        int sign = (x>0) ? 1 : -1;
        x = Math.abs(x);
        int rev =0;
        while(x>0){
            // check overflow
            if(rev> Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && x> Integer.MAX_VALUE%10)) return 0;
            rev = rev * 10 + x%10;
            x /=10;
        }
        return sign * rev;
    }
}
