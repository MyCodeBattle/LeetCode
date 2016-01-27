/*
 * 这个dp有点神的感觉。用dp[i][k]搞了半天搞不出来。
 * dp[k][i]表示直到第i天交易了k次的最大获利。
 * dp[k][i] = max(dp[k - 1][i], dp[k - 1][j] + price[i] - price[j])。
 * 就是说今天要么不交易，要么从前一轮的某一天转移过来。
 * 我们一边遍历一边维护dp[k - 1][j] - price[j]即可。
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 1)
            return 0;
        int[][] dp = new int[3][len];

        for (int k = 1; k <= 2; k++) {
            int temp = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + temp);
                temp = Math.max(temp, dp[k - 1][i] - prices[i]);
            }
        }
        return dp[2][len - 1];
    }
}
