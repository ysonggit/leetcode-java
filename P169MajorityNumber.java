public class Solution {
    // moore's voting algorithm
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int maj_num = nums[0];
        int count = 1;
        for(int i=1; i<n; i++){
            if(nums[i]==maj_num){
                count++;
            }else{
                count--;
            }
            if(count==0){
                maj_num = nums[i];
                count = 1;
            }
        }
        return maj_num;
    }
}
