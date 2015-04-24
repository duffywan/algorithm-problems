public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // edge case: do not have to buy if profit is negtive
        int max = 0;
        int buyin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - buyin);
            buyin = Math.min(prices[i], buyin);
        }
        return max;
    }
}