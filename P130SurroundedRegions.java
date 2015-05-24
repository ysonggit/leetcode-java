public class Solution {
    // BFS 
    // 1. for each 'O' on the board, do DFSearch, replace 'O' with 'Y'
    // 2. Replace rest 'O's with 'X's
    // 3. Replace 'Y's with 'O's
    // dfs causes java.lang.StackOverflowError
    /* public void dfs(char[][] board, int i, int j){
        if(i<0 ||j<0 || i==board.length || j== board[0].length) return;
        if(board[i][j]!='O') return;
        board[i][j] ='Y';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
    }*/
    class Pos {
        int x, y;
        Pos(int i, int j){ 
            x = i;
            y = j;
        }
    }
    
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    
    public void bfs(char[][] board, int i, int j){
        if(board[i][j]!='O') return;
        int m = board.length;
        int n = board[0].length;
        Queue<Pos> Q = new LinkedList<Pos>();
        Q.offer(new Pos(i, j));
        while(!Q.isEmpty()){
            Pos cur = Q.poll();
            int row = cur.x, col = cur.y;
            if(row < 0|| col <0 || row ==m || col==n) continue;
            if(board[row][col]!='O') continue;
            board[row][col] = 'Y';
            for(int k=0; k<4; k++){
                Pos neighbor = new Pos(row+dx[k], col+dy[k]);
                Q.offer(neighbor);
            }
        }
    }
    
    public void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        // check 'O's on boards
        for(int i=0; i<m; i++){ // left and right col
            bfs(board, i, 0);
            bfs(board, i, n-1);
        }
        for(int j=0; j<n; j++){ // top and bottom row
            bfs(board, 0, j);
            bfs(board, m-1, j);
        }
        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j]=='O') board[i][j] = 'X';
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='Y') board[i][j] = 'O';
            }
        }
    }
}
