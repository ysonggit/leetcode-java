public class Solution {
    class Pos{
        int x, y;
        Pos(int i, int j){
            x=i;
            y=j;
        }
    }
    int dx [] = {1, -1, 0, 0};
    int dy [] = {0, 0, 1, -1};
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m==0) return;
        int n = rooms[0].length;
        boolean visited[][] = new boolean[m][n];
        Queue<Pos> Q = new LinkedList<Pos>();
        for(int i=0; i<m; i++){
            Arrays.fill(visited[i], false);
            for(int j=0; j<n; j++){
                if(rooms[i][j]==0){
                    visited[i][j] = true;
                    Q.add(new Pos(i, j));
                } 
            }
        }
        int level = 1;
        while(!Q.isEmpty()){
            int num_cur_level = Q.size();
            for(int i=0; i<num_cur_level; i++){
                Pos cur = Q.poll();
                for(int j=0; j<4; j++){
                    Pos nb = new Pos(cur.x+dx[j], cur.y+dy[j]);
                    if(nb.x<0 || nb.x>=m || nb.y<0 || nb.y>=n) continue;
                    if(visited[nb.x][nb.y] || rooms[nb.x][nb.y]==-1) continue;
                    visited[nb.x][nb.y] = true;
                    rooms[nb.x][nb.y] = level;
                    Q.add(nb);
                }
            }
            level++;
        }
    }
}
