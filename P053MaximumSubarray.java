public class Solution {
    /*
        track two variables: max_ending_here (local), max_so_far (global)
                       [−2,1,−3, 4,−1,2,1,−5,4]
       max_ending_here   0 1  0  4  3 5 6 1  5
       max_so_far       -2 1  1  4  4 5 6 6  6
       
                       [-2, -1]   [-2 1]
                        -2  -1     -2 1
                        -2  -1     -2 1
    */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int max_so_far = nums[0], max_ending_here = nums[0];// mistake max_ending_here=nums[0]
        for(int i=1; i<n; i++){
            max_ending_here = Math.max(nums[i], nums[i]+max_ending_here);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
}
