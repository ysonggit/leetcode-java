public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n==0) return n;
        int rev = 0;
        for(int i=0; i<32; i++){
            int mask = 1<<i;
            int mask_n = mask & n;
            int bit = mask_n >>i;
            if(bit != 0) rev |= (1<<(31-i)); // mistake |= not +=
        }
        return rev;
    }
}
