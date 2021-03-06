public class Solution {
    public boolean dfs(char [][] board, String word, int cur_idx, 
                    int i, int j, boolean[][] visited){
        int m = board.length, n = board[0].length;
        if(i<0||j<0||i==m||j==n) return false;
        boolean visited [][] = new boolean[m][n];
        if(board[i][j]!=word.charAt(cur_idx)) return false;
        if(cur_idx==word.length()-1) return true;
        visited[i][j] = true;
        boolean found = dfs(board, word, cur_idx+1, i+1, j, visited) || 
            dfs(board, word, cur_idx+1, i-1, j, visited) || 
            dfs(board, word, cur_idx+1, i, j+1, visited) || 
            dfs(board, word, cur_idx+1, i, j-1, visited);
        visited[i][j] = false;
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m==0) return word.length()==0;
        int n = board[0].length;
        boolean visited [][] = new boolean[m][n];
        for(int i=0; i<m ; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0)==board[i][j] && 
                    dfs(board, word, 0, i, j, visited)) return true;
            }
        }
        return false;
    }
}
