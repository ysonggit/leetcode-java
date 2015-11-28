public class Solution {
    // inverse BFS: from leaves, remove each leaf level by level until root 
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);
        // trick : use hashset instead of arraylist
        Map<Integer, HashSet<Integer>> graph = new HashMap<Integer, HashSet<Integer>>();
        for(int i=0; i<n; i++) graph.put(i, new HashSet<Integer>());
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for(Map.Entry<Integer, HashSet<Integer>> entry : graph.entrySet()){
            if(entry.getValue().size()==1) leaves.add(entry.getKey());
        }
        while(n>2){
            List<Integer> newleaves = new ArrayList<Integer>();
            for(int leaf : leaves){
                for(int nb : graph.get(leaf)){
                    graph.get(leaf).remove(nb);
                    graph.get(nb).remove(leaf);
                    n--;
                    if(graph.get(nb).size()==1) newleaves.add(nb);
                }
            }
            leaves = newleaves;
        }
        return leaves;
    }
}
