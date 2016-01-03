public class Solution {
    // roots[i] = j root of vertex[i] is the vertex[j]
    public int find(int vertex, int [] roots){
        if(vertex ==roots[vertex]) return vertex;
        roots[vertex] = find(roots[vertex], roots);
        return roots[vertex];
    }
    public int countComponents(int n, int[][] edges) {
        // mark set 
        int [] roots = new int [n];
        for(int i=0; i<n; i++) roots[i] = i;
        int count = 0;
        // union
        for(int [] edge : edges){
            int v = edge[0], u = edge[1];
            int root_v = find(v, roots);
            int root_u = find(u, roots);
            if(root_v!=root_u) roots[root_u] = root_v;
        }
        for(int i=0; i<n; i++){
            if(roots[i]==i) count++;
        }
        return count;
    }
}
