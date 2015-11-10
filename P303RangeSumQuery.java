public class NumArray {
    int [] prefix_sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        prefix_sum = new int[n+1];
        for(int i=0; i<nums.length; i++){ // assume no overflow
            prefix_sum [i+1] = prefix_sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return prefix_sum[j+1] - prefix_sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
