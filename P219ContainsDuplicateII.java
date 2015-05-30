public class Solution {
   public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if(n<2) return false;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            int cur = nums[i];
            if(!map.containsKey(cur)){
                map.put(cur, new ArrayList<Integer>());
                map.get(cur).add(i);
            }else{
                for(int j : map.get(cur)){
                    if(Math.abs(i-j)<=k) return true;
                }
                map.get(cur).add(i);
            }
        }
        return false;
    }
}
