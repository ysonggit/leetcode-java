public class Solution {
    public void swap(int[] nums, int front, int back){
        if(front>=back) return;
        while(front<back){
            int tmp = nums[front];
            nums[front] = nums[back];
            nums[back] = tmp;
            front++;
            back--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n<2 || k<0 ||k%n==0) return;
        // rotate entire array
        int front=0, back =n-1;
        swap(nums, front, back);
        // rotate two subarrays
        if(k>n) k = k%n;
        front = 0;
        back = k-1;
        swap(nums, front, back);
        front = k; 
        back = n-1;
        swap(nums, front, back);
    }
}
