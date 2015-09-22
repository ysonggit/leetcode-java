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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null || p== null) return null;
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        // the successor could be the root or in the right subtree of the root
        TreeNode candidate = inorderSuccessor(root.left, p);
        return (candidate==null) ? root : candidate;  
    }
}
