public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int front=0, back=n-1;
        while(front<back){
            int mid = (front+back)/2;
            if(mid<back&& nums[mid]> nums[mid+1]){
                return nums[mid+1];
            }else if(mid>front  && nums[mid] < nums[mid-1]){
                return nums[mid];
            }else if(nums[mid]>nums[back]) {
                // [4 5 6 7 0 1 2]
                front=mid+1;
            }else{
                // [7 0 1 2 3 4]
                back = mid-1;
            }
        }
        return nums[0];
    }
}
