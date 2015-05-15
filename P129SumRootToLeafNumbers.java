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
    public int sumPath(TreeNode node, int cur_sum){
        if(node==null) return cur_sum;
        cur_sum = cur_sum * 10 + node.val;
        if(node.left == null && node.right == null) return cur_sum;
        if(node.left == null) return sumPath(node.right, cur_sum);
        if(node.right== null) return sumPath(node.left, cur_sum);
        return sumPath(node.left, cur_sum) + sumPath(node.right, cur_sum);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return sumPath(root, 0);
    }
}
