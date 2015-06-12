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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode leftcopy = root.left;
        TreeNode rightcopy = root.right;
        root.left = rightcopy;
        root.right = leftcopy;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
