public class NumMatrix {
    // integral image problem DP
    int [][] sums;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return;
        int n = matrix[0].length;
        sums = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                sums[i][j] = matrix[i-1][j-1] + sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] + sums[row1][col1] - sums[row2+1][col1] - sums[row1][col2+1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
