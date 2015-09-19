public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m==0) return 0;
        int n= obstacleGrid[0].length;
        int D[][] = new int[m][n];
        D[0][0] = (obstacleGrid[0][0]>0) ? 0 : 1;
        if(D[0][0]==0) return 0;
        for(int i=1; i<m; i++){
            D[i][0] = (D[i-1][0]==1 && obstacleGrid[i][0]==0) ? 1 : 0;
        }
        for(int j=1; j<n; j++){
            D[0][j] = (D[0][j-1]==1 && obstacleGrid[0][j]==0) ? 1 : 0;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                D[i][j] = (obstacleGrid[i][j]==0) ? D[i-1][j]+D[i][j-1] : 0;
            }
        }
        return D[m-1][n-1];
    }
}
