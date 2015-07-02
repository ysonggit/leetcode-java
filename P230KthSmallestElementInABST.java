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
    // inorder traversal => non-decreasing sequence
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        TreeNode cur = root;
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        int count = 0;
        while(!parentStack.empty() || cur != null){
            if(cur!= null){
                parentStack.push(cur);
                cur = cur.left;
            }else{
                cur = parentStack.pop();
                count++;
                if(count == k){
                    return cur.val;
                }
                cur = cur.right;
            }
        }
        return root.val;
        
    }
}
