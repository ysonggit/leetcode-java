public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==0) return new int[0];
        int res[] = new int[2];
        HashMap<Integer, Integer> existed = new HashMap<Integer, Integer>();
        for(int i =0; i<nums.length; i++){
            int j = target - nums[i];
            if(existed.containsKey(j) ){
                res[0] = Math.min(i+1, existed.get(j)+1);
                res[1] = Math.max(i+1, existed.get(j)+1);
            }else{
                existed.put(nums[i], i);
            }
        }
        return res;
    }
}
