public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        // assumes the n>=3
        int a = nums[0];
        for(int i=1; i<n; i++){
            a = a^ nums[i];
        }
        return a;
    }
}
