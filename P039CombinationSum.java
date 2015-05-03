public class Solution {
    public void dfs(List<List<Integer>> res, int[] candidates, List<Integer> sol, int cur_idx, int target){
        int n = candidates.length;
        if(target<0 ) return;
        if(target==0){
            List<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
            return ;
        }
        for(int i=cur_idx; i<n; i++){
            int cur = candidates[i];
            if(i>cur_idx && cur==candidates[i-1]) i++;
            if(target >= cur){ //mistake : don't use > 
                sol.add(cur);
                dfs(res, candidates, sol, i, target-cur);
                sol.remove(sol.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = candidates.length;
        if(n==0) return res;
        Arrays.sort(candidates);  // mistake: output format: non-decreasing order
        List<Integer> sol = new ArrayList<Integer>();
        dfs(res, candidates, sol, 0, target);
        return res;
    }
}
