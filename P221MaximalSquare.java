public class Solution {
    public boolean isSquare(char[][] matrix, int row, int col, int len){
        if(row+len> matrix.length) return false; // mistake:  out range error, use > not >=!
        if(col+len> matrix[0].length) return false;
        for(int i=row; i<row+len; i++){
            for(int j=col; j<col+len; j++){
                if(matrix[i][j]=='0') return false;
            }
        }
        return true;
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        int max_area = 0;
        int max_len = Math.min(m, n);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int len=1; len<= max_len; len++){
                    if(isSquare(matrix, i, j, len)) {
                        max_area = Math.max(max_area, len*len);   
                    }
                }
            }
        }
        return max_area;
    }
}
