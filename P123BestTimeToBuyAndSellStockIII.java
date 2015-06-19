public class Solution {
    // similar to trapping rain water, candy (two passes) solution
    //        [2,1,2,0,1]
    // before [0 0 1 1 1]
    //  after [1 1 1 1 0]
    public int maxProfit(int[] prices) {
        int n= prices.length;
        if(n<2) return 0;
        // max_before[i] : max profit can be obtained before day i
        int [] max_before = new int[n];
        int min_price = prices[0];
        for(int i=1; i<n; i++){
            int diff = prices[i] - min_price;
            max_before[i] = Math.max(max_before[i-1], diff);
            min_price = Math.min(min_price, prices[i]);
        }
        // max_after[i] : max profit can be obtained after day i
        int [] max_after = new int [n];
        int max_price = prices[n-1];
        for(int i=n-2; i>=0; i--){
            int diff = max_price - prices[i];
            max_after[i] = Math.max(max_after[i+1], diff);
            max_price = Math.max(max_price, prices[i]);
        }
        int max_profit = 0;
        for(int i=0; i<n; i++){
            int local_max = max_before[i]+max_after[i];
            if(local_max > max_profit){
                max_profit = local_max;
            }
        }
        return max_profit;
    }
}
