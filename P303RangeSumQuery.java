public class NumArray {
    int [] prefix_sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        if(n==0) return;
        prefix_sum = new int[n];
        prefix_sum[0] = nums[0];
        for(int i=1; i<nums.length; i++){ // assume no overflow
            prefix_sum [i] = prefix_sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i>j || prefix_sum.length==0) return 0;
        if(i==0) return prefix_sum[j];
        return prefix_sum[j] - prefix_sum[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
