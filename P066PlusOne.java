public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for(int i=n-1; i>=0; i--){
            int cur_bit = digits[i];
            digits[i] = (cur_bit + carry)%10;
            carry = (cur_bit + carry)/10;
        }
        if(carry==0) return digits;
        int res[] = new int[n+1];
        // arraycopy (src, srcStart, dest, destStart, len)
        System.arraycopy(digits, 0, res, 1, n);
        res[0] = 1;
        return res;
    }
}
