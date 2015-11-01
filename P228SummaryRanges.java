public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int n = nums.length, start = 0, end=0;
        if(n==0) return res;
        while(end<n){
            while(end<n-1 && nums[end+1]-nums[end]==1){
                end++;
            }
            if(start==end) res.add(String.valueOf(nums[start]));
            else res.add(nums[start]+"->"+nums[end]);
            end++;
            start = end;
        }
        return res;
    }
}
