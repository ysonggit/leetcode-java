/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeLinkNode connectRecur(TreeLinkNode node){
        if(node == null) return null;
        if(node.left == null && node.right ==null) return node;
        if(node.next != null) { 
            node.right.next = node.next.left;
        }
        node.left.next = node.right;
        node.right = connectRecur(node.right);
        node.left = connectRecur(node.left);
        return node;
    }
    public void connect(TreeLinkNode root) {
        root = connectRecur(root);
    }
}
