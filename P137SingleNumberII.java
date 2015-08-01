public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int sum_of_each_bit [] = new int [32];
        for(int cur : nums){
            for(int i=0; i<32; i++){
                int mask = 1;
                int rightmost = (cur >> i) & mask;
                sum_of_each_bit[31-i] += rightmost;
            }
        }
        int res = 0;
         for(int j=0; j<32; j++){
            res = (res << 1);
            res += sum_of_each_bit[j] %3;
        }
        return res;
    }
}
