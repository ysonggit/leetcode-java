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
    public TreeNode construct(int[] inorder, int[] postorder, int start_in, int end_in, int start_post, int end_post){
        if(start_in>end_in || start_post> end_post) return null;
        int root_val = postorder[end_post];
        int root_pos = 0;
        for(int i=start_in; i<= end_in; i++){
            if(inorder[i]==root_val) {
                root_pos = i;
                break;
            }
        }
        int left_size = root_pos - start_in;
        TreeNode root = new TreeNode(root_val);
        root.left = construct(inorder, postorder, start_in, root_pos-1, start_post, start_post+left_size-1);
        root.right= construct(inorder, postorder, root_pos+1, end_in, start_post+left_size, end_post-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return construct(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
}
