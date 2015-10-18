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
    public boolean isUnival(TreeNode root, int v){
        if(root== null) return true;
        if(root.val != v) return false;
        if(root.left ==null && root.right ==null) return true; // important!
        return isUnival(root.left, v) && isUnival(root.right, v);
    }
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        int count = isUnival(root, root.val) ? 1 : 0;
        return count + countUnivalSubtrees(root.left)+ countUnivalSubtrees(root.right);
    }
}
