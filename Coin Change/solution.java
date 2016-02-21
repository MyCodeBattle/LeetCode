/*
 * 记忆化搜索。
 */

public class Solution {
    int[] dp;
    private int dfs(int n, int[] coins) {
        if (n == 0 || dp[n] != 0)
            return dp[n];
        dp[n] = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; ++i) if (coins[i] <= n) {
            int res = dfs(n - coins[i], coins);
            if (res != Integer.MAX_VALUE)
                dp[n] = Math.min(dp[n], res + 1);
        }
        return dp[n];
    }

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        return dfs(amount, coins) == Integer.MAX_VALUE ? -1 : dfs(amount, coins);
    }
}
