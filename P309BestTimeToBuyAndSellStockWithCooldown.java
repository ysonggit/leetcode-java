public class Solution {
    // from whnzinc
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = Integer.MIN_VALUE;
        int noop = buy;
        int sell =0, cool = 0;
        for(int i=0; i<n; i++){
            int price = prices[i];
            buy = cool - price;
            cool = Math.max(sell, cool);
            noop = Math.max(buy, noop);
            sell = noop + price;
        }
        return Math.max(sell, cool);
    }
}
