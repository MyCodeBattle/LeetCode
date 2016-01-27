/*
 * 保存一下如果不卖的话股票最低价，然后维护一下卖的最大利益。
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - dp[i - 1]);
            dp[i] = Math.min(dp[i - 1], prices[i]);
        }
        return ans;
    }
}
