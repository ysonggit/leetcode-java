/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> all_levels_vals = new ArrayList<List<Integer>>();
        if(root==null) return all_levels_vals;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        int current_level = 1;
        int next_level = 0;
        List<Integer> vals = new ArrayList<Integer>();
        while(!Q.isEmpty()){
            TreeNode cur = Q.poll();
            current_level--;
            vals.add(cur.val);
            if(cur.left !=null) {
                Q.offer(cur.left);
                next_level++;
            }
            if(cur.right != null){
                Q.offer(cur.right);
                next_level++;
            }
            if(current_level==0){
                current_level = next_level;
                next_level = 0;
                List<Integer> current_level_vals = new ArrayList<Integer>(vals);
                all_levels_vals.add(current_level_vals);
                vals.clear();
            }
            
        }
        return all_levels_vals;
    }
}
