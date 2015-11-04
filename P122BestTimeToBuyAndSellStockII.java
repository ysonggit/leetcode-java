public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2) return 0;
        int max_profit = 0;
        for(int i=1; i<n; i++){
            int diff = prices[i] - prices[i-1];
            if(diff>0) max_profit += diff; 
        }
        return max_profit;
    }
}
