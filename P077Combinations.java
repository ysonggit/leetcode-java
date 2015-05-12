public class Solution {
    public void dfs(List<List<Integer>> res, ArrayList<Integer> sol, int n, int k, int cur){
        if(sol.size()==k) {
            List<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
            return;
        }
        for(int i=cur; i<=n; i++){
            sol.add(i);
            dfs(res, sol, n, k, i+1);
            sol.remove(sol.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n==0) return res;
        ArrayList<Integer> sol = new ArrayList<Integer>();
        dfs(res, sol, n, k, 1);
        return res;
    }
}
