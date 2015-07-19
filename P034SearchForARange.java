public class Solution {
    /*
        binary search:
        once find the target, search left and right one-by-one to find the start/end
    */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int [] range = new int []{-1, -1};
        if(n==0) return range;
        int front = 0, back = n-1;
        while(front<=back){
            int mid = (front+back)/2;
            if(nums[mid]==target){
                int start = mid, end = mid;
                while(start>0 && nums[start-1]== target) start--;
                while(end<n-1 && nums[end+1]==target ) end++;
                return new int[]{start, end};
            }else if (nums[mid]<target){
                front=mid+1;
            }else{
                back = mid-1;
            }
        }
        return range;
    }
}
