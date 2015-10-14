public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n<2) return 0;
        if(k>=n){
            int max_profit = 0;
            for(int i=1; i<n; i++){
                int diff = prices[i] - prices[i-1];
                if(diff>0) max_profit += diff;
            }
            return max_profit;
        }
        int D[][] = new int [n][k+1];
        for(int j=1; j<=k; j++){
            int max_diff = D[0][j] - prices[0];
            for(int i=1; i<n; i++){
                D[i][j] = Math.max(D[i-1][j], max_diff+prices[i]);
                max_diff = Math.max(max_diff, D[i][j-1]-prices[i]);
            }
        }
        return D[n-1][k];
    }
}
