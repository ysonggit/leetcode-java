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
    public int getMaxDepth(TreeNode root){
        if(root==null) return 0;
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int diff = Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right));
        if(diff>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
