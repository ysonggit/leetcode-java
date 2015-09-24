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
    // solution from siyang3 and anniekim
    public void recoverTree(TreeNode root) {
        TreeNode pre = null, first=null, second=null;
        // call morris inorder traversal
        TreeNode cur = null;
        while(root!=null){
            if(root.left != null){
                // connect threading for the root
                cur = root.left;
                while(cur.right!=null && cur.right!=root){
                    cur = cur.right;
                }
                // if threading already exists
                if(cur.right != null){
                    // replace Outputting root.val with order check
                    if(pre!=null && pre.val > root.val){
                        if(first==null)  first = pre;
                        second = root;
                    }
                    pre = root;
                    cur.right = null;
                    root = root.right;
                }else{
                    // create threading fro the root
                    cur.right = root;
                    root = root.left; // mistake : NOT right
                }
            }else{
                // replace Outputting root.val with order check
                if(pre!=null && pre.val > root.val){
                    if(first==null)   first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        // swap first and second
        if(first!= null && second!=null){
            int tmp = first.val;   // swap value only
            first.val = second.val; 
            second.val = tmp;
        }
    }
}
