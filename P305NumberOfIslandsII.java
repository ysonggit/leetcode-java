public class Solution {
    // from hpplayer
    public int find(int idx, int [] roots){
        if(idx==roots[idx]) return idx;
        roots[idx] = find(roots[idx], roots);
        return roots[idx];
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        if(m==0) return res;
        boolean [][] filled = new boolean[m][n];
        int [] roots = new int[m*n];
        int [] dx = {1,-1,0,0};
        int [] dy = {0,0,1,-1};
        int num_islands=0;
        for(int [] coord : positions){
            int i = coord[0], j = coord[1];
            filled[i][j] = true;
            roots[i*n+j] = i*n+j;
            num_islands++;
            for(int k=0; k<4; k++){
                int nb_i = i+dx[k], nb_j = j+dy[k];
                if(nb_i<0|| nb_i>=m || nb_j<0||nb_j>=n) continue;
                if(!filled[nb_i][nb_j]) continue;
                int cur_root = find(i*n+j, roots);
                int nb_root = find(nb_i*n + nb_j, roots);
                if(cur_root != nb_root){
                    num_islands--;
                }
                roots[nb_root] = cur_root;
            } 
            res.add(num_islands);
        }
        return res;
    }
}
