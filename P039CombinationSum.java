public class Solution {
    public void dfs(List<List<Integer>> res, int[] candidates, ArrayList<Integer> sol, int cur_idx, int cur_sum, int target){
        if(cur_sum==target){
            List<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
            return;
        }
        if(cur_idx == candidates.length) return;
        if(cur_sum>target) return;
        for(int i=cur_idx; i<candidates.length; i++){
            sol.add(candidates[i]);
            dfs(res, candidates, sol, i, cur_sum+candidates[i], target);
            sol.remove(sol.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = candidates.length;
        if(n==0) return res;
        ArrayList<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(res, candidates, sol, 0, 0, target);
        return res;
    }
}
