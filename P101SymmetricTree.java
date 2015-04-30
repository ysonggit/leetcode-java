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
    public boolean mirror(TreeNode leftnode, TreeNode rightnode){
        if(leftnode==null && rightnode==null) return true;
        if(leftnode==null || rightnode==null) return false;
        if(leftnode.val != rightnode.val) return false;
        return mirror(leftnode.right, rightnode.left) && mirror(leftnode.left, rightnode.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return mirror(root.left, root.right);
    }
}
