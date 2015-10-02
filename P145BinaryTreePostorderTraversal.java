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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<Integer>();
        if(root==null) return vals;
        Stack<TreeNode> first = new Stack<TreeNode>();
        Stack<TreeNode> second = new Stack<TreeNode>();
        first.push(root);
        while(!first.empty()){
            TreeNode cur = first.pop();
            second.push(cur);
            if(cur.left !=null) first.push(cur.left);
            if(cur.right!=null) first.push(cur.right);
        }
        while(!second.empty()){
            int v = second.pop().val;
            vals.add(v);
        }
        return vals;
    }
}
