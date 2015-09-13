public class Solution {
    // DP solution:
    // D[i]  the maximum subarray sum of first i numbers
    // D[i] = max(A[i], A[i]+D[i-1])
    // D[0] = 0
    // return max(D[i]) for i in [0,n-1]
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int D[] = new int[n+1];
        int max_idx = 1;
        for(int i=1; i<=n; i++){
            D[i]= Math.max(nums[i-1], nums[i-1]+D[i-1]);
            if(D[i] > D[max_idx]){
                max_idx = i;
            }
        }
        return D[max_idx];
    }
}
