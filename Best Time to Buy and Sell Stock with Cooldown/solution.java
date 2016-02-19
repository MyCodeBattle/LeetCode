/*
 * 我们用0, 1, 2表示最后一次操作是买、卖、什么都不做的最大获利值。
 * 那么dp[i][0]可以从两个状态转移过来，一个是之前买过一次了，现在在持有的profit，另一个是之前的观望状态的profit，然后买现在的股票，减去price[i].
 *
 * 其他的同理。
 * 然后看一下这三个递推式，都只是和前一个状态有关，所以改成变量，这样空间复杂度就变成O(1)了。
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length + 1][3];

        dp[0][0] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
        }
        int len = prices.length;
        return Math.max(Math.max(dp[len][0], dp[len][1]), dp[len][2]);
    }
}
