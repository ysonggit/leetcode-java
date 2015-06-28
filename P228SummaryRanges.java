public class Solution {
    public String getRange(int start, int end){
        if(start==end) return String.valueOf(start);
        return String.valueOf(start).concat("->").concat(String.valueOf(end));
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int n = nums.length;
        int start =0, end = 0;
        while(end<n){
            if(end<n-1){
                if(nums[end+1]-nums[end]==1){
                    end++;
                }else{
                    res.add(getRange(nums[start], nums[end]));
                    end++;
                    start = end;
                }
            }else{
                res.add(getRange(nums[start], nums[end]));
                return res;
            }
        }
        return res;
    }
}
