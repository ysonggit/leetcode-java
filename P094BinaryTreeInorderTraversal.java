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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<Integer>();
        if(root==null) return vals;
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!parentStack.empty() || cur != null){
            if(cur!=null){
                parentStack.push(cur);
                cur = cur.left;
            }else{
                cur = parentStack.pop();
                vals.add(cur.val);
                cur = cur.right;
            }
        }
        return vals;
    }
}
