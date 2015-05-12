public class Solution {
    public void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> sol, boolean [] visited){
        if(sol.size() == nums.length){
            List<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
            return ;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i] == false){
                visited[i]=true;
                sol.add(nums[i]);
                dfs(res, nums, sol, visited);
                sol.remove(sol.size()-1);
                visited[i]=false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = nums.length;
        if(n==0) return res;
        ArrayList<Integer> sol = new ArrayList<Integer>();
        boolean visited [] = new boolean [n];
        dfs(res, nums, sol, visited);
        return res;
    }
}
