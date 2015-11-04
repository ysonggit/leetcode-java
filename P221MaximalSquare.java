public class Solution1 {
    // naive brute force solution
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

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n==0) return 0;
        int m = matrix[0].length;
        int D[][] = new int[n+1][m+1];
        int max_len = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(matrix[i-1][j-1]=='0') D[i][j]=0;
                else{
                    D[i][j] = 1+Math.min(Math.min(D[i][j-1], D[i-1][j]), D[i-1][j-1]);
                }
                max_len = Math.max(max_len, D[i][j]);
            }
        }
        return max_len*max_len; // assume no overflow
    }
}
