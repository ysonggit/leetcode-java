public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        if(n==2) {
            if(nums[0]>nums[1]) return 0;
            else return 1;
        }
        int front =0, back=n-1;
        while(front<=back){
            int mid = (front+back)/2;
            if(mid==0 && nums[mid]>nums[mid+1]) return mid;
            if(mid==n-1 && nums[mid] > nums[mid-1]) return mid;
            if(nums[mid] > nums[mid+1]  && nums[mid] >nums[mid-1]) return mid;
              else if(nums[mid] < nums[mid+1]){
                  front = mid+1;
              }else{
                  back = mid-1;
              }  
        }
        return 0;
    }
}
