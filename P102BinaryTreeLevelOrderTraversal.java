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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        while(!Q.isEmpty()){
            int level_num = Q.size();
            List<Integer> vals = new ArrayList<Integer>();
            for(int i=0; i<level_num; i++){
                TreeNode cur = Q.poll();
                vals.add(cur.val);
                if(cur.left!=null) Q.offer(cur.left);
                if(cur.right!=null) Q.offer(cur.right);
            }
            res.add(vals);
        }
        return res;
    }
}
