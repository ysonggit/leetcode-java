public class Solution {
    public int getMinMax(int[] A, boolean get_max){
        int n = A.length;
        if(n==0) return get_max ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int ans = A[0];
        for(int i=1; i<n; i++){
            ans = get_max ? Math.max(ans, A[i]) : Math.min(ans, A[i]);
        }
        return ans;
    } 
     
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        int max_val = getMinMax(nums, true);
        int min_val = getMinMax(nums, false);
        double interval_size = (double)(max_val- min_val)/ n; // mistake: using int size is wrong: 1/2 = 0 
        // now create n intervals 
        int max_in_interval[] = new int[n];
        int min_in_interval[] = new int[n];
        // initialize these two arrays
        Arrays.fill(max_in_interval, Integer.MIN_VALUE);
        Arrays.fill(min_in_interval, Integer.MAX_VALUE);
        // fill the "proper" number to each interval
        for(int i : nums){
            // Trick: auto ceiling, figure out i should be in which interval
            // this is cool, just make sure tp check the boundary 
            int interval_idx = (int) Math.ceil((i-min_val)/interval_size);
            if(interval_idx >= n) interval_idx = n-1;
            // update corresponding max/min_in_interval value
            max_in_interval[interval_idx] = Math.max(i, max_in_interval[interval_idx]);
            min_in_interval[interval_idx] = Math.min(i, min_in_interval[interval_idx]);
        }
        // finally find the max_gap
        int max_in_prev_interval = max_in_interval[0];
        int max_gap = 0; 
        for(int i=1; i<n; i++){
            if(min_in_interval[i] == Integer.MAX_VALUE
            || max_in_interval[i] == Integer.MIN_VALUE){
                continue; // empty interval
            }
            int cur_gap = min_in_interval[i] - max_in_prev_interval;
            max_gap = Math.max(max_gap, cur_gap);
            max_in_prev_interval = max_in_interval[i];
        }
        return max_gap;
    }
}
