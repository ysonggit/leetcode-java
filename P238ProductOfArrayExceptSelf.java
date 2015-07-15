public class Solution {
    /*
    O(n) time O(n) space
    nums   2   3   4   5   6 
    left 1 2   6   24  120 720
    right  720 360 120 30  6   1
    prod   360 240 180 144 120
    */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prod[] = new int[n];
        if(n==0) return prod;
        int left_prod[] = new int[n]; // assume mulitplication does not overflow
        int right_prod[] = new int[n];
        left_prod[0] = nums[0];
        for(int i=1; i<n; i++){
            left_prod[i] = left_prod[i-1] * nums[i];
        }
        right_prod[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            right_prod[i] = right_prod[i+1] * nums[i];
        }
        for(int i=0; i<n; i++){
            int left = (i==0) ? 1 : left_prod[i-1];
            int right = (i==n-1) ? 1 : right_prod[i+1];
            prod[i] = left * right;
        }
        return prod;
    }
}
