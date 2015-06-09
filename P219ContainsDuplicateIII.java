public class Solution {
    // maintains a window of size k
    // use treeset (ordered set)
    // key: TreeSet.higher(i): Returns the least element in this set strictly greater than i
    // O(nlogk) time O(k) space
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if(n<2) return false;
        TreeSet<Integer> window = new TreeSet<Integer>();
        int leftmost_idx = 0;
        for(int i=0; i<n; i++){
            if(i-leftmost_idx>k){
                // size exceeds k, should remove one number from window 
                // this guarantees the idx difference <= k
                window.remove(nums[leftmost_idx]);
                leftmost_idx++;
            }
            // check numbers in window : from leftmost_idx .. i
            // if any number pairs satisfy
            int cur = nums[i];    
            Integer low = window.higher(cur-t-1); // low >= cur-t
            if(low != null && Long.valueOf(low) <= Long.valueOf(cur)+Long.valueOf(t) ){ // mistake : overflow Long.valeOf(cur+t) is wrong
                return true;
            }  
            window.add(cur);
        }
        return false;
    }
}
