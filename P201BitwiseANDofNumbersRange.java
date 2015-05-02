public class Solution {
    // find the leftmost bit of 1 which owned by both lower and higher bounds
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n){
            m = m>>1;
            n = n>>1;
            count++;
        }
        return m<<count;
    }
}
