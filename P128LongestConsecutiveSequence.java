public class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        Set<Integer> vals = new HashSet<Integer>();
        for(int i : nums){
            vals.add(i);
        }
        int max_consec_len = 1;
        for(int cur : nums) {
            int cur_consec_len = 1;
            Integer left = cur - 1;
            while(vals.contains(left)){
                cur_consec_len++;
                vals.remove(left);
                left--;
            }
            Integer right = cur + 1;
            while(vals.contains(right)){
                cur_consec_len++;
                vals.remove(right);
                right++;
            }
            vals.remove(cur);
            max_consec_len = Math.max(max_consec_len, cur_consec_len);
        }
        return max_consec_len;
    }
}
