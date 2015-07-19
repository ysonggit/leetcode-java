public class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return 0;
        int front = 0, back = n-1;
        while(front<=back){
            int mid = (front+back)/2;
            if(nums[mid]== target) {
                return mid;
            }else if(nums[mid]<target){
                front= mid+1;
            }else{
                back = mid-1;
            }
        }
        return front;
    }
}
