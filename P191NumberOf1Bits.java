public class Solution {
    // you need to treat n as an unsigned value
    // n & (n-1) zeros the rightmost 1 everytime
    public int hammingWeight(int n) {
        int count =0;
        while(n!=0){ // mistake: n>0 is wrong. i.e. n =100000...00
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
