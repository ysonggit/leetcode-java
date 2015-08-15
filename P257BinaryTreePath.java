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
    public void dfs(List<String> paths, TreeNode node, String cur_path){
        if(node==null) return;
        String cur_node_val = String.valueOf(node.val);
        if(cur_path.length()>0) {
            cur_path = cur_path.concat("->").concat(cur_node_val); // mistake: must use assign = 
        }else {
            cur_path = cur_path.concat(cur_node_val);
        }
        if(node.left==null && node.right==null) {
            // reached a leaf already
            paths.add(new String(cur_path)); 
            return;   
        }
        // recursion
        if(node.left !=null) dfs(paths, node.left, cur_path);
        if(node.right != null) dfs(paths, node.right, cur_path);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        if(root == null) return paths;
        String cur_path = "";
        dfs(paths, root, cur_path);
        return paths;
    }
}
