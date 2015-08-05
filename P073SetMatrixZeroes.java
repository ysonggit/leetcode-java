public class Solution {
    public void zeroCol(int [][]matrix, int col){
        for(int i=0; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
    public void zeroRow(int [][] matrix, int row){
        for(int i=0; i<matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return;
        int n = matrix[0].length;
        boolean zero_first_col = false, zero_first_row = false;
        for(int i=0; i<m; i++){
            if(matrix[i][0]==0) zero_first_col = true;
        }
        for(int i=0; i<n; i++){
            if(matrix[0][i]==0) zero_first_row = true;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=1; i<n; i++){
            if(matrix[0][i]==0) zeroCol(matrix, i);
        }
        for(int i=1; i<m; i++){
            if(matrix[i][0]==0) zeroRow(matrix, i);
        }
        if(zero_first_col) zeroCol(matrix, 0);
        if(zero_first_row) zeroRow(matrix, 0);
    }
}
