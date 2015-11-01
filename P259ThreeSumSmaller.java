public class Solution {
    public int twoSum(int[] nums, int start, int sum){
        int end = nums.length-1;
        int num_pairs = 0;
        while(start<end){
            if(nums[start]+nums[end]< sum){
                num_pairs += end-start;
                start++;
            }else{
                end--;
            }
        }
        return num_pairs;
    }
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int total = 0;
        for(int i=0; i<nums.length-2; i++){
            total += twoSum(nums, i+1, target-nums[i]);
        }
        return total;
    }
}
