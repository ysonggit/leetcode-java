public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        // n& (n-1) : clear the right most bit
        return ((n&(n-1))==0) ? true : false;
    }
}
