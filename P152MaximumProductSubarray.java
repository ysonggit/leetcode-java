public class Solution {
    /*
                  [-2 3 -4]
     max_local     -2 3 24
     min_local     -2 -6 -12
     max_global    -2 3  24 
     
                  [-4 -3 -2]
                   -4  12 6 
                   -4  -3 -24
                   -4  12 12
                   
                   [0 2]
                    0 2
                    0 0
                    0 2
    */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int max_global = nums[0];
        int max_local = nums[0];
        int min_local = nums[0];
        for(int i=1; i<n; i++){
            int cur = nums[i];
            int local_max_copy = max_local;
            int local_min_copy = min_local;
            // mistabke: Math.max(Math.max(local_max_copy, local_min_copy) *cur, cur); is incorrect!
            max_local = Math.max(Math.max(local_max_copy*cur, local_min_copy *cur), cur);
            min_local = Math.min(Math.min(local_max_copy*cur, local_min_copy *cur), cur);
            max_global = Math.max(max_local, max_global);
            
        }
        return max_global;
    }
}
