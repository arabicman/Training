package leetcode.algorithm.Q714_BestTimeBuyAndSellWithTransactionFee;

public class Solution {
    //[0, 0, 0, 6, 6, 9]
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        for(int i = 0; i < prices.length; i++){
            int lastBuy = buy;
            buy = Math.max(lastBuy, sell - prices[i]);
            sell = Math.max(sell, lastBuy + prices[i] - fee);
        }
        return sell;
    }




}
    /*  Time Exceed
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = Math.max(dp[0], prices[1]-prices[0]-fee);
        int max = Math.max(dp[0],dp[1]);
        for(int i = 2; i < prices.length; i++){
            int curMax = prices[i] - prices[0] - fee;
            for(int j = 0; j < i-1; j++){
                int cur = dp[j] + (prices[i]-prices[j+1]-fee);
                curMax = Math.max(curMax, cur);
            }
            max = Math.max(max, curMax);
            dp[i] = max;
        }
        return dp[prices.length - 1];

    }
    */