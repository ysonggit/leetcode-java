/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution1 {
    public boolean mirror(TreeNode leftnode, TreeNode rightnode){
        if(leftnode==null && rightnode==null) return true;
        if(leftnode==null || rightnode==null) return false;
        if(leftnode.val != rightnode.val) return false;
        return mirror(leftnode.right, rightnode.left) && mirror(leftnode.left, rightnode.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return mirror(root.left, root.right);
    }
}


public class Solution2 {
    // iterative BFS version
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root.left);
        Q.offer(root.right);
        while(!Q.isEmpty()){
            TreeNode l = Q.poll();
            TreeNode r = Q.poll();
            if(l==null && r==null) continue;
            if(l==null || r==null) return false;
            if(l.val != r.val) return false;
            Q.offer(l.left);
            Q.offer(r.right);
            Q.offer(l.right);
            Q.offer(r.left);
        }
        return true;
    }
}
