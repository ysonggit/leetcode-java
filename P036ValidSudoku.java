public class Solution {
    public boolean valid(boolean [] visited, char cur){
        if(cur != '.'){
            int pos = (int) cur -'1';
            if(visited[pos])  return false;
            visited[pos] = true;
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        if(n==0) return true;
        boolean visited[] = new boolean [n];
        // check each row
        for(int i=0; i<n; i++){
            Arrays.fill(visited, false);
            for(int j=0; j<n; j++){
                char cur = board[i][j];
                if(!valid(visited, cur)) return false;
            }
        }
        // check each col
        for(int j=0; j<n; j++){
            Arrays.fill(visited, false);
            for(int i=0; i<n; i++){
                char cur = board[i][j];
                if(!valid(visited, cur)) return false;
            }
        }
        // check each box
        for(int i=0; i<n; i+=3){
            for(int j=0; j<n; j+=3){
                Arrays.fill(visited, false);
                for(int k=0; k<n; k++){
                    char cur = board[i+k/3][j+k%3];
                    if(!valid(visited, cur)) return false;
                }
            }
        }
        return true;
    }
}
