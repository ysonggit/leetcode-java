public class Solution {
    // find out how many 5s 
    // 20! -> 4 trailing zeroes
    // be careful of overflow
    public int trailingZeroes(int n) {
        int count =0;
        for(long i=5; i<=n; i=i*5){
            count += n/i;
        }
        return count;
    }
}
