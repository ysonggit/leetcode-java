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
    void dfs(List<Integer> res, TreeNode cur, int level){
        if(cur==null) return;
        if(level== res.size()) {
            res.add(cur.val);
        }
        dfs(res, cur.right, level+1);
        dfs(res, cur.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res, root, 0);
        return res;
    }
}
