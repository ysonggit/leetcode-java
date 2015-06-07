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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left==null && root.right==null) return 1;
        int left_level=0, right_level=0;
        TreeNode leftroot = root, rightroot = root;
        while(leftroot != null){
            left_level++;
            leftroot = leftroot.left;
        }
        while(rightroot != null){
            right_level++;
            rightroot = rightroot.right;
        }
        // full tree
        if(left_level == right_level) return (1<<left_level)-1; // (2^h)-1
        // complete but not full tree
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
