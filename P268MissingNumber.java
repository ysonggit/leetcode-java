public class Solution {
    // bucket sort
    // maintain: A[i] = i
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]<n && nums[i] != nums[nums[i]]){
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }else{
                i++;
            }
        }
        for(int j=0; j<n; j++){
            if(nums[j]!= j) return j;
        }
        return n; // [0] should return 1
    }
}
