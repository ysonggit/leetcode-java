/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 * BFS
 */
public class Solution1 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer, UndirectedGraphNode> cloned = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> Q = new LinkedList<UndirectedGraphNode>();
        Q.offer(node);
        cloned.put(node.label, new UndirectedGraphNode(node.label));
        while(!Q.isEmpty()){
            UndirectedGraphNode cur = Q.poll();
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!cloned.containsKey(neighbor.label)){
                    cloned.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    Q.offer(neighbor);
                }
                cloned.get(cur.label).neighbors.add(cloned.get(neighbor.label));
            }
        }
        return cloned.get(node.label);
    }
}
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 * DFS
 */
public class Solution2 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer, UndirectedGraphNode> cloned = new HashMap<Integer, UndirectedGraphNode>();
        Stack<UndirectedGraphNode> Q = new Stack<UndirectedGraphNode>();
        Q.push(node);
        cloned.put(node.label, new UndirectedGraphNode(node.label));
        while(!Q.empty()){
            UndirectedGraphNode cur = Q.pop();
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!cloned.containsKey(neighbor.label)){
                    cloned.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    Q.push(neighbor);
                }
                cloned.get(cur.label).neighbors.add(cloned.get(neighbor.label));
            }
        }
        return cloned.get(node.label);
    }
}
