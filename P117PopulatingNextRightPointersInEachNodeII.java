/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeLinkNode nearestCousin(TreeLinkNode parent){
        if(parent == null) return null;
        if(parent.left!=null) return parent.left;
        if(parent.right!=null) return parent.right;
        return nearestCousin(parent.next);
    }
    public void populate(TreeLinkNode root, TreeLinkNode parent){
        if(root == null) return;
        if(parent!=null && parent.right==root){
            root.next = nearestCousin(parent.next);
        }
        if(parent!=null && parent.left==root){
            root.next = (parent.right != null) ? parent.right : nearestCousin(parent.next);
        }
        populate(root.right, root);
        populate(root.left, root);
    }
    public void connect(TreeLinkNode root) {
        populate(root, null);
    }
}
