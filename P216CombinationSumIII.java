public class Solution {
    public void dfs(List<List<Integer>> res, ArrayList<Integer> sol, int k, int target, int cur, int cur_sum){
        if(cur_sum > target || sol.size()>k ) return; // mistake: put if(cur>9) return; is wrong
        if(cur_sum == target && sol.size() == k){
            List<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
            return;
        }
        for(int i=cur; i<=9; i++){
            sol.add(i);
            dfs(res, sol, k, target, i+1, cur_sum+i);
            sol.remove(sol.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k==0|| n<=0) return res;
        ArrayList<Integer> sol = new ArrayList<Integer>();
        dfs(res, sol, k, n, 1, 0);
        return res;
    }
}
