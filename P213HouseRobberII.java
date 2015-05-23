public class Solution {
    /**
     * idea: 
     * remove the first house then apply hourse robber I, that is : rob from 1 to n-1
     * remove the last house then apply hourse robber I, that is, rob from 0 to n-2
     * choose the max of above two 
     */
    public int robI(int[] nums){
        int n = nums.length;
        int M[] = new int [n+1]; // actually can use two variables instead
        M[0] = 0;
        M[1] = nums[0];
        for(int i=2; i<=n; i++){
            int cur = nums[i-1];
            M[i] = Math.max(M[i-2]+ cur, M[i-1]);
        }
        return M[n];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int [] nums1 = new int [n-1];
        int [] nums2 = new int [n-1];
        System.arraycopy(nums, 0, nums1, 0, n-1);
        System.arraycopy(nums, 1, nums2, 0, n-1);
        return Math.max(robI(nums1), robI(nums2));
    }
}
