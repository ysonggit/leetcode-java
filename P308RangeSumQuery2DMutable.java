public class NumMatrix {
    int rows, cols;
    int [][] tree;
    int [][] nums;
    public NumMatrix(int[][] matrix) {
        rows = matrix.length;
        if(rows==0) return;
        cols = matrix[0].length;
        tree = new int [rows+1][cols+1];
        nums = new int [rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                update(i, j, matrix[i][j]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for(int i=row+1; i<=rows; i+=(i&(-i))){
            for(int j=col+1; j<=cols; j+=(j&(-j))){
                tree[i][j] += diff;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }
    
    public int sum(int row, int col){
        int s = 0;
        for(int i=row; i>0; i-=(i&(-i))){
            for(int j=col; j>0; j-=(j&(-j))){
                s += tree[i][j];
            }
        }
        return s;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
