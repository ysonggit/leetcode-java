public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0) return 0;
        int n = grid[0].length;
        int sum [][]= new int[m][n];
        sum[0][0] = grid[0][0];
        for(int i=1; i<n; i++){
            sum[0][i] = sum[0][i-1] + grid[0][i]; 
        }
        for(int j=1; j<m; j++){
            sum[j][0] = sum[j-1][0] + grid[j][0];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }
        return sum[m-1][n-1];
    }
}
