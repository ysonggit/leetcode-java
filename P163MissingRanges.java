public class Solution {
    public String generateRange(int lower, int upper){
        if(lower > upper) return "";
        if(lower == upper) return String.valueOf(lower);
        return String.valueOf(lower) + "->" +String.valueOf(upper);
    }
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int n = nums.length;
        int lowbound = lower -1;
        for(int i: nums){
            if(i-lowbound >= 2){
                res.add(generateRange(lowbound+1, i-1));
            }
            lowbound = i;
        }
        // mistake: corner case: [] 1 1 should return {"1"}
        if((n>0 && upper > nums[n-1]) || (n==0)) res.add(generateRange(lowbound+1, upper));
        return res;
    }
}
