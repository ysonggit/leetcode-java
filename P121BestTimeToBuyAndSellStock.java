public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<2) return 0;
        int max_profit = 0;
        int min_price = prices[0];
        for(int i=1; i<n; i++){
            int cur_price = prices[i];
            int diff = cur_price - min_price;
            if(diff> max_profit){
                max_profit = diff;
            }
            min_price = Math.min(min_price, cur_price);
        }
        return max_profit;
    }
}
