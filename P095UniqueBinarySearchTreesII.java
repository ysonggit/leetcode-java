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
    public void build(List<TreeNode> roots, int start, int end){
        if(start>end){ 
            roots.add(null);
            return;
        }
        for(int i=start; i<=end; i++){
            List<TreeNode> L = new ArrayList<TreeNode>();
            build(L, start, i-1);
            List<TreeNode> R = new ArrayList<TreeNode>();
            build(R, i+1, end);
            for(TreeNode a : L){
                for(TreeNode b : R){
                    TreeNode root = new TreeNode(i);
                    root.left = a;
                    root.right = b;
                    roots.add(root);
                }
            }
        }
    }
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        build(res, 1, n);
        return res;
    } 
}
