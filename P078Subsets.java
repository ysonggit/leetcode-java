public class Solution {
    public void dfs(List<List<Integer>> res, ArrayList<Integer> sol, int[] nums, int cur_idx){
        if(cur_idx == nums.length){
            List<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
            return;
        }
        // pass by current element
        dfs(res, sol, nums, cur_idx+1);
        // add current element to subset
        sol.add(nums[cur_idx]);
        dfs(res, sol, nums, cur_idx+1);
        sol.remove(sol.size()-1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length==0) return res;
        ArrayList<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(res, sol, nums, 0);
        return res;
    }
}
