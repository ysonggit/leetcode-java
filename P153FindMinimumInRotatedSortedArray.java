public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int front=0, back=n-1;
        while(front<back){
            int mid = front+(back-front)/2;
            if(nums[mid] > nums[back]){
                front = mid+1;
            }else{
                back = mid;
            }
        }
        return nums[back];
    }
}
