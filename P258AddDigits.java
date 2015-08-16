public class Solution {
    // https://en.wikipedia.org/wiki/Digital_root
    // digital root: If a number produces a digital root of exactly 9, then the number is a multiple of 9
    // digital root (n) = 1 + (n-1)%9
    public int addDigits(int num) {
        return 1 + (num-1)%9;
    }
}
