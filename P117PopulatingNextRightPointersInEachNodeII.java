/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeLinkNode closestRight(TreeLinkNode upper_level_node){
        if(upper_level_node==null) return null;
        if(upper_level_node.left!=null) return upper_level_node.left;
        if(upper_level_node.right!=null) return upper_level_node.right;
        return closestRight(upper_level_node.next); // keep on look for the next upper level node's child
    } 
    public TreeLinkNode topDownRecur(TreeLinkNode root, TreeLinkNode upper_level_node){
        if(root==null) return null;
        if(upper_level_node!=null && root == upper_level_node.right){
            root.next = closestRight(upper_level_node.next);
        }
        if(upper_level_node!=null && root == upper_level_node.left){
            if(upper_level_node.right != null) {
                root.next = upper_level_node.right;
            }else{
                root.next = closestRight(upper_level_node.next);
            }
        }
        root.right = topDownRecur(root.right, root);
        root.left = topDownRecur(root.left, root);
        return root;
    }
    public void connect(TreeLinkNode root) {
        root = topDownRecur(root, null);
    }
}
