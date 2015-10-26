/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        StringBuilder res = new StringBuilder();
        while(!s.empty()){
            TreeNode cur = s.pop();
            if(res.length()>0) res.append(",");
            if(cur==null){
                res.append("#");
            }else{
                res.append(String.valueOf(cur.val));
                s.push(cur.right);
                s.push(cur.left);
            }
        }
        return res.toString();
    }
    
    String rest;
    public TreeNode extractNode(String s){
        if(s.length()==0) return null;
        int comma_pos = s.indexOf(",");
        if(comma_pos ==-1){
            if(s.equals("#")) return null;
            return new TreeNode(Integer.valueOf(s));
        }
        String cur = s.substring(0, comma_pos);
        rest = s.substring(comma_pos+1);
        if(!cur.equals("#")){
            TreeNode root = new TreeNode(Integer.valueOf(cur));
            root.left = extractNode(rest);
            root.right = extractNode(rest);
            return root;
        }
        return null;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return extractNode(data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
