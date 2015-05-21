/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void dfs(List<List<Integer>> res, ArrayList<Integer> sol, TreeNode root, int cur_sum, int target){
        //if(cur_sum>target) return; // mistake when nodes vals are negative
        if(root==null) return;
        sol.add(root.val);
        cur_sum += root.val;
        if(cur_sum==target && root.left==null && root.right==null){
            List<Integer> path = new ArrayList<Integer>(sol);
            res.add(path);
            return;
        }
        ArrayList<Integer> sol1 = new ArrayList<Integer>(sol); // mistake: can not pass sol directly
        dfs(res, sol1, root.left, cur_sum, target);
        
        ArrayList<Integer> sol2 = new ArrayList<Integer>(sol);
        dfs(res, sol2, root.right, cur_sum, target);
        
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        ArrayList<Integer> sol = new ArrayList<Integer>();
        dfs(res, sol, root, 0, sum);
        return res;
    }
}
