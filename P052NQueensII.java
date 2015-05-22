public class Solution {
    int count = 0;
    public boolean ok(int [] queens, boolean [] arranged_cols, int cur_row, int cur_col){
        if(arranged_cols[cur_col]) return false;
        for(int i=0; i<cur_row; i++){
            int j = queens[i]; 
            if(j>=0){
                if(Math.abs(j-cur_col) == cur_row - i) return false;
            }
        }
        return true;
    }
    public void dfs(int [] queens, boolean [] arranged_cols, int cur_row){
        if(cur_row==queens.length){
            count++;
            return;
        }
        // for each un-arranged column, check each row if it is ok to place a queen
        for(int j=0; j<queens.length; j++){
            if(arranged_cols[j]==false){
                if(ok(queens, arranged_cols, cur_row, j)){
                    queens[cur_row] = j;
                    arranged_cols[j] = true;
                    dfs(queens, arranged_cols, cur_row+1);
                    arranged_cols[j] = false;
                    queens[cur_row] = -1;
                }
            }
        }
    }
    public int totalNQueens(int n) {
        if(n<=1) return n;
        // arranged_cols[i] = true in column i, there is a queen
        boolean arranged_cols [] = new boolean [n]; 
        // queens[i] = j means the queen i is placed in column j
        int queens [] = new int [n]; 
        Arrays.fill(queens, -1);
        dfs(queens, arranged_cols, 0);
        return count;
    }
}
