public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int [][] D = new int [n+1][3];
        for(int i=1; i<=n; i++){
            D[i][0] = costs[i-1][0] + Math.min(D[i-1][1], D[i-1][2]);
            D[i][1] = costs[i-1][1] + Math.min(D[i-1][0], D[i-1][2]);
            D[i][2] = costs[i-1][2] + Math.min(D[i-1][0], D[i-1][1]);
        }
        return Math.min(Math.min(D[n][0], D[n][1]), D[n][2]);
    }
}
