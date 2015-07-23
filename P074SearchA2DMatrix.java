public class Solution {
    // basic solution: search from top right corner
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        int row = 0, col = n-1;
        while(row<m && col>=0){
            int cur = matrix[row][col];
            if(target == cur) {
                return true;
            }else if(target < cur){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
