public class Solution {
    // DFS Version
    public void dfs(char[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i<0|| j<0 ||i==n||j==m) return;
        if(grid[i][j]=='0' ) return ;
        grid[i][j] ='0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n==0) return 0;
        int m = grid[0].length;
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]!='0'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
/* 
public class Solution {
    // BFS Version
    class Pos{
        int x, y;
        Pos(int i, int j){x=i; y=j;}
    }
    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};
    public void bfs(char[][] grid, int i, int j){
        if(grid[i][j] != '1') return; // water, return 
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pos> Q= new LinkedList<Pos>();
        Q.offer(new Pos(i, j));
        while(!Q.isEmpty()){
            Pos cur = Q.poll();
            if(cur.x <0 || cur.y<0|| cur.x==m || cur.y==n) continue;
            if(grid[cur.x][cur.y]!='1') continue;
            grid[cur.x][cur.y] = '0'; // mark visited land as water
            for(int k=0; k<4; k++){
                Pos neighbor = new Pos(cur.x+dx[k], cur.y+dy[k]);
                Q.offer(neighbor);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    count++;  
                    bfs(grid, i, j);
                } 
            }
        }
        return count;
    }
}
*/
