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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        int cur = root.val;
        if(root.left == null && root.right==null && cur == sum) return true;
        return hasPathSum(root.left,sum-cur) || hasPathSum(root.right,sum-cur);
    }
}
