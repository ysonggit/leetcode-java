public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=2) return n;
        int j = 1;
        int count = 1;
        for(int i = 1; i<n; i++){
            if(nums[i] != nums[i-1]){
                nums[j] = nums[i]; 
                j++;
                count = 1;
            }else{
                count++;
                if(count>2){
                    continue;
                }else{
                    nums[j] = nums[i];
                    j++;
                }
            }
        }
        return j;
    }
}
