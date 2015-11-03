public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max_len = 0;;
        int D[] = new int[n];
        for(int i=0; i<n; i++){
            D[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]) D[i] = Math.max(D[i], D[j]+1);
            }
            max_len = Math.max(max_len, D[i]);
        }
        return max_len;
    }
}
