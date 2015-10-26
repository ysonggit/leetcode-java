public class Solution1 {
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

public class Solution2 {
    public int binarySearch(int[] nums, int low, int high){
        if(low>high) return -1;
        if(high-low<=1) return nums[low] > nums[high] ? low : high; // mistake: must consider this case
        int mid = (high-low)/2 + low;
        int left = mid>0 ? nums[mid-1] : Integer.MIN_VALUE;
        int right = mid<nums.length-1 ? nums[mid+1] : Integer.MIN_VALUE;
        if(nums[mid] > left && nums[mid]> right) return mid;
        if(nums[mid] < right) return binarySearch(nums, mid+1, high);
        return binarySearch(nums, low, mid-1);
    }
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
}
