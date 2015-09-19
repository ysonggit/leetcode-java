public class Solution {
    public int uniquePaths(int m, int n) {
        if(m<=0|| n<=0) return 0;
        int D[][] = new int[m][n];
        for(int [] row : D){
            Arrays.fill(row, 1);
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                D[i][j] = D[i-1][j] + D[i][j-1];
            }
        }
        return D[m-1][n-1];
    }
}
