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
    int max_len = 0;
    public void dfs(TreeNode root, int pre_len){
        max_len = Math.max(max_len, pre_len);
        if(root==null) return;
        if(root.left != null){
            if(root.left.val - root.val==1) dfs(root.left, pre_len+1);
            else dfs(root.left, 1);
        }
        if(root.right!=null){
            if(root.right.val - root.val==1) dfs(root.right, pre_len+1);
            else dfs(root.right, 1);
        }
    }
    public int longestConsecutive(TreeNode root) {
        if(root==null) return 0;
        dfs(root, 1);
        return max_len;
    }
}
