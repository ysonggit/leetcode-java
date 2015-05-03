/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> nodes;
    public BSTIterator(TreeNode root) {
        nodes = new Stack<TreeNode>();
        if(root!=null){
            TreeNode cur = root;
            while(cur != null){
                nodes.push(cur);
                cur = cur.left;
            }
        }    
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodes.empty();
    }

    /** @return the next smallest number */
    public int next() {
        if(nodes.empty()) return 0;
        TreeNode cur = nodes.pop();
        int val = cur.val;
        if(cur.right !=null){
            cur = cur.right;
            while(cur != null){
                nodes.push(cur);
                cur = cur.left;
            }
        }
        return val;
    }
}
