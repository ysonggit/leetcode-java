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
    // level order traversal, save the right most value
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> vals = new ArrayList<Integer>();
        if(root==null) return vals;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        int curr_level = 1;
        int next_level = 0;
        ArrayList<Integer> cur_level_vals = new ArrayList<Integer>();
        while(!Q.isEmpty()){
            TreeNode cur = Q.poll();
            curr_level--;
            cur_level_vals.add(cur.val);
            if(cur.left != null){
                Q.offer(cur.left);
                next_level++;
            }
            if(cur.right !=null){
                Q.offer(cur.right);
                next_level++;
            }
            if(curr_level==0){
                curr_level = next_level;
                next_level = 0;
                vals.add(cur_level_vals.get(cur_level_vals.size()-1));
                cur_level_vals.clear();
            }
        }
        return vals;
    }
}
