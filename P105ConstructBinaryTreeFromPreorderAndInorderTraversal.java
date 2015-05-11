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
    public TreeNode build(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend, HashMap<Integer, Integer> inorder_pos){
        if(prestart>preend || instart>inend) return null;
        int val = preorder[prestart];
        TreeNode root = new TreeNode(val);
        int pos = inorder_pos.get(val);
        int leftsize = pos-instart;
        int rightsize = inend-pos;
        root.left = build(preorder, inorder, prestart+1, prestart+leftsize, instart, pos-1, inorder_pos); 
        root.right = build(preorder, inorder, preend-rightsize+1, preend, pos+1, inend, inorder_pos);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int []  inorder){
        int n = preorder.length;
        if(n==0) return null;
        HashMap<Integer, Integer> inorder_pos = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++){
            inorder_pos.put(inorder[i],i);
        }   
        return build(preorder, inorder, 0, n-1, 0, n-1, inorder_pos);
    }
}
