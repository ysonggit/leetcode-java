public class Solution {
    public void dfs(List<List<Integer>> res, List<Integer> sol, int n, int start){
        if(n==1){
            if(sol.size()==1) return;
            Collections.sort(sol);
            res.add(new ArrayList(sol));
            return;
        }
        for(int factor=start; factor<=n; factor++){
            if(n%factor==0){
                sol.add(factor);
                dfs(res, sol, n/factor, factor);
                sol.remove(sol.size()-1);
            }
        }
    }
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n<4) return res;
        List<Integer> sol = new ArrayList<Integer>();
        dfs(res, sol, n, 2);
        return res;
    }
}
