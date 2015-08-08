public class Solution {
    /*
        1,2,4,3  -> 1,3,2,4
        |
        1,3,4,2
        |
        1,3,2,4
    */
    public void reverseArray(int[] A, int start, int end){
        if(start>end) return;
        while(start<end){
            int tmp = A[start];
            A[start] = A[end];
            A[end]= tmp;
            start++;
            end--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n<2) return;
        // from right, search increasing subsequence
        int i=n-1;
        while(i>0 && nums[i-1] >= nums[i]) i--; // mistake : >= not >. ex: 5 1 1 should return 1 1 5
        if(i==0){
            reverseArray(nums, 0, n-1);
            return;
        }
        int pivot_idx = i-1;
        // search from i to n-1
        // find the last number greater than the pivot
        while(i<n && nums[i] > nums[pivot_idx]) i++;
        int least_gt_pivot_idx = i-1;    
        // swap pivot with least_gt_pivot_idx
        int tmp = nums[pivot_idx];
        nums[pivot_idx] = nums[least_gt_pivot_idx];
        nums[least_gt_pivot_idx] = tmp;
        reverseArray(nums, pivot_idx+1, n-1);
    }
}
