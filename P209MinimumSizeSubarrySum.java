public class Solution {
     public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int front=0, back=0;
        int min_size = n+1;
        int sum=0;
        while(back<n){
            int cur = nums[back];
            if(cur==s) return 1;
            sum += cur;
            if(sum >=s){
                min_size = Math.min(min_size, back-front+1);
                sum = 0;
                front++;
                back=front;
            }else{
                back++;
            }
        }
        return (min_size >n) ? 0 : min_size;
    }
}
