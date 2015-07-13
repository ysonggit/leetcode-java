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
    /*
        recursively traverse the BST: 
        if node's value is greater than both n1 and n2 then our LCA lies in left side of the node, 
        if it's is smaller than both n1 and n2, then LCA lies on right side. 
        Otherwise root is LCA 
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(p.val > q.val) return lowestCommonAncestor(root, q, p);
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
