public class Solution {
    public int maxProfit(int[] prices) {
        // space O(1)
        // time O(n), O(n^2) will exceeds time limit
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        // compute for the first transation, using a loop up table to cache history result
        int[] maxBefore = new int[prices.length];
        int buyin = prices[0];
        for(int i = 1; i < prices.length; i++){
            maxBefore[i] = Math.max(maxBefore[i - 1], prices[i] - buyin); // sell no later than day i
            buyin = Math.min(buyin, prices[i]);
        }
        
        // computer the twotransations together with the second transation
        int sell = prices[prices.length - 1];
        int max = 0;
        for (int i = prices.length- 2; i >= 0; i--) { // buy no early than day i
            max = Math.max(max, sell - prices[i] + (i - 1 >= 0 ? maxBefore[i - 1] : 0));
            sell = Math.max(sell, prices[i]);
        }
        return max;
    }
}