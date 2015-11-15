public class Solution {
    public int find(int idx, int[] roots){
        if(idx==roots[idx]) return idx;
        roots[idx] = find(roots[idx], roots);
        return roots[idx];
    }
    public boolean validTree(int n, int[][] edges) {
        if(n<=1) return (edges.length<1);
        int [] roots = new int[n];
        // initialize
        for(int i=0; i<n; i++){
            roots[i] = i;
        }
        for(int[] edge : edges){
            int in = edge[0], out = edge[1];
            int in_root = find(in, roots);
            int out_root = find(out, roots);
            if(in_root == out_root) return false;
            //union
            roots[out_root] = in_root;  // mistake if let root[out] = in_root
        }
        // return true;// mistake : 4 , [[0,1],[2,3]] if form two trees should return false
        return edges.length == n-1 ? true : false; // if successfully form 1 tree, then must have exact n-1 edges
    }
}
