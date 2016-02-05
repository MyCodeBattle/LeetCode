/*
 * 和上个差不多，加个特判：当k大于总数的一半时，说明可以随便买随便卖了。
 */

public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        if (k > prices.length / 2) {
            int ans = 0, preBuyPrice = prices[0];
            for (int num : prices) {
                if (num > preBuyPrice) 
                    ans += num - preBuyPrice;
                preBuyPrice = num;
            }
            return ans;
        }

        int[][] dp = new int[k + 1][prices.length];

        int ans = 0;
        for (int i = 1; i <= k; ++i) {
            int earn = -prices[0];
            for (int j = 1; j < prices.length; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], earn + prices[j]);
                earn = Math.max(earn, dp[i - 1][j] - prices[j]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(dp[2][4]);
        return ans;
    }
}
