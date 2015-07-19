public class Solution {
    /*
        similar to 3 sum, but maintains the minimum diff between sum_val and target 
        -4 -1 1 2 | 1
    */
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n<3) return 0;
        Arrays.sort(nums);
        int closest_sum = 0, min_diff = Integer.MAX_VALUE;
        for(int i=0; i<n-2; i++){
            int front = i+1, back = n-1;
            int desired_sum = target - nums[i];
            while(front<back){
                int two_sum = nums[front]+nums[back];
                int diff = Math.abs(desired_sum - two_sum);
                if(two_sum == desired_sum){
                    return target;
                }else{ 
                    if(two_sum < desired_sum){
                        front++;
                    }else{
                        back--;
                    }
                    if(diff< min_diff){
                        min_diff = diff;
                        closest_sum = two_sum + nums[i];
                    } 
                }
            }
        }
        return closest_sum;
    }
}
