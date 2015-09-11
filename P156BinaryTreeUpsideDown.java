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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root==null) return null;
        if(root.left == null && root.right==null) return root;
        TreeNode right_cp = root.right;
        TreeNode left_cp = root.left;
        TreeNode new_root = upsideDownBinaryTree(root.left);
        left_cp.right = root;
        left_cp.left = right_cp;
        // amazing: must set left_cp first then null current root
        root.left = null;
        root.right= null;
        return new_root;
    }
}
