public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int buyin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1] && (i == prices.length - 1 || prices[i] >= prices[i + 1])) {
                max += prices[i] - buyin;
                buyin = prices[i];
            } else {
                buyin = Math.min(prices[i], buyin);
            }
        }
        return max;
    }
}