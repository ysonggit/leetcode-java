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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        Map<Integer, ArrayList<Integer>> col_nodes = new TreeMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Queue<Integer> C = new LinkedList<Integer>();
        Q.offer(root);
        C.offer(0);
        while(!Q.isEmpty()){
            int num = Q.size();
            for(int k=0; k<num; k++){
                TreeNode cur = Q.poll();
                int col = C.poll();
                if(!col_nodes.containsKey(col)){
                    col_nodes.put(col, new ArrayList<Integer>());
                }
                if(cur.left!=null){
                    Q.offer(cur.left);
                    C.offer(col-1);
                }
                if(cur.right!=null){
                    Q.offer(cur.right);
                    C.offer(col+1);
                }
                col_nodes.get(col).add(cur.val);
            }
        }
        for(Map.Entry<Integer, ArrayList<Integer>> entry : col_nodes.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
}
