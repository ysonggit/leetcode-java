public class Solution {
    public void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> sol, int cur_idx){
        if(!res.contains(sol)){
            List<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
        //  return;
        }
        for(int i=cur_idx; i<nums.length; i++){
            sol.add(nums[i]);
            dfs(res, nums, sol, i+1);
            sol.remove(sol.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(n==0) return res;
        Arrays.sort(nums);
        ArrayList<Integer> sol = new ArrayList<Integer>();
        dfs(res, nums, sol, 0);
        return res;
    }
}
