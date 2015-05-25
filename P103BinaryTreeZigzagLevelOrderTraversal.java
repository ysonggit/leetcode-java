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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> vals = new ArrayList<List<Integer>>();
        if(root==null) return vals;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        int curr_level = 1, next_level =0;
        ArrayList<Integer> cur_level_vals = new ArrayList<Integer>();
        boolean left_to_right = true;
        while(!Q.isEmpty()){
            TreeNode cur = Q.poll();
            curr_level--;
            cur_level_vals.add(cur.val);
            if(cur.left != null){
                Q.offer(cur.left);
                next_level++;
            }
            if(cur.right != null){
                Q.offer(cur.right);
                next_level++;
            }
            if(curr_level==0){
                curr_level = next_level;
                next_level = 0;
                if(left_to_right){
                    left_to_right = false;
                }else{
                    Collections.reverse(cur_level_vals);
                    left_to_right = true;
                }
                List<Integer> level_vals = new ArrayList<Integer>(cur_level_vals);
                vals.add(level_vals);
                cur_level_vals.clear();
            }
        }
        return vals;
    }
}
