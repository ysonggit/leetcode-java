/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 1) flatten left subtree
   2) flatten right subtree
   3) append 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Bottom Up Recursion
 * For each node
 * 1) flatten left subtree and right subtree
 * 2) if flattened left subtree is not null, 
          append flattened right subtree to the tail of left subtree
      else
          set the left subtree root to be the root of flattened right subtree
 * 3) set node.left child to null and right child to the root of the flattened left subtree 
 * 4) return node
 */
public class Solution {
    public TreeNode helper(TreeNode root){
        if(root==null) return null;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if(left == null){
            left = right;
        }else{
            TreeNode left_tail = left;
            while(left_tail!=null && left_tail.right!=null) left_tail = left_tail.right;
            if(left_tail != null) left_tail.right = right;
        }
        root.left = null;
        root.right= left;
        return root;
    }
    public void flatten(TreeNode root) {
        helper(root);
    }
}
