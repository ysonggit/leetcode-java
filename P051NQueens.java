public class Solution {
    /*
        Representation:
        queens[i]=j means a queen is at row i, col j
        arranged_cols[k]=true means column k is arranged with a queen
        Idea
        for each un-arranged column, iterate each row to check if OK to place a queue 
    */
    boolean ok(int[] queens, boolean [] arranged_cols, int row, int col){
        if(arranged_cols[col]==true) return false;
        for(int i=0; i<row; i++){
            if(queens[i] >= 0){
                if(row-i == Math.abs(queens[i]-col)) return false;
            }
        }
        return true;
    }
    
    void dfs(List<String[]> boards, int [] queens, boolean[] arranged_cols, int cur_row){
        int n = queens.length;
        if(cur_row==n){
            // generate board
            String board[] = new String[n];
            for(int i=0; i<n; i++){
                StringBuilder row = new StringBuilder();
                for(int j=0; j<n; j++){
                    if(j==queens[i]) row.append('Q');
                    else row.append('.');
                }
                board[i] = row.toString();
            }
            boards.add(board);
            return;
        }
        for(int col=0; col<n; col++){
            if(ok(queens, arranged_cols, cur_row, col)){
                queens[cur_row] = col;
                arranged_cols[col]=true;
                dfs(boards, queens, arranged_cols, cur_row+1);
                arranged_cols[col]=false;
                queens[cur_row] = -1;
            }
            
        }
    }
    public List<String[]> solveNQueens(int n) {
        List<String[]> boards = new ArrayList<String[]>();
        if(n==0) return boards;
        int queens[] = new int[n];
        Arrays.fill(queens, -1);
        boolean arranged_cols[] = new boolean[n];
        dfs(boards, queens, arranged_cols, 0);
        return boards;
    }
}
