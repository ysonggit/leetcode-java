public class Solution {
    public boolean binarySearch(int []A, int low, int high, int target){
        if(low>high) return false;
        int mid = low +(high-low)/2;
        if(A[mid]==target) return true;
        boolean left = binarySearch(A, low, mid-1, target);
        if(left) return left;
        return binarySearch(A, mid+1, high, target);
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n==0) return false;
        return binarySearch(nums, 0, n-1, target);
    }
}
