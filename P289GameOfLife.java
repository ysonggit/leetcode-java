public class Solution {
    // trick: use two bits to represent history states
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        int offsets[][] = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int count = 0;
                for(int k=0; k<8; k++){
                    int x = i+offsets[k][0], y = j+offsets[k][1];
                    if(x<0||x>=m||y<0||y>=n) continue;
                    if((board[x][y] & 1)==1) count++;
                }
                if((board[i][j]&1)==0){ // current dead x0
                    if(count==3) board[i][j] = 2; // next live 10
                }else{
                    if(count<2 || count>3) board[i][j]= 1; //next dead 01
                    else board[i][j] = 3; // next still live 11
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] >>=1;
            }
        }
    }
}
