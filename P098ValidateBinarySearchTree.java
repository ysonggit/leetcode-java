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
    // inorder traversal
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> parentStack= new Stack<TreeNode>();
        TreeNode cur = root;
        long max_val_sofar = Long.MIN_VALUE;
        while(!parentStack.empty() || cur != null){
            if(cur!=null){
                parentStack.push(cur);
                cur = cur.left;
            }else{
                cur = parentStack.pop();
                if(cur.val <= max_val_sofar) return false;
                max_val_sofar = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}
