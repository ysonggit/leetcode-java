public class Solution {
    // two pointers 
    // 1 1 1 1 1 1 1
    public void moveZeroes(int[] nums) {
        int n= nums.length;
        if(n<2) return;
        int non_zero_idx= 0;
        for(int i=0; i<n; i++){
            if(nums[i]!=0){
                nums[non_zero_idx++] = nums[i];
            }
        }
        for(int j=non_zero_idx; j<n; j++){
            nums[j] = 0;
        }
    }
}
