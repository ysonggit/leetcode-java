public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int start = 0, end = 0, sum = 0;
        int min_len = n+1;
        while(end<n){
            if(nums[end]>=s) return 1;
            sum+= nums[end];
            while(sum >=s && start <end){
                min_len = Math.min(min_len, end-start+1);
                sum -= nums[start++];
            }
            end++;
        }
        return min_len > n ? 0 : min_len;
    }
}
