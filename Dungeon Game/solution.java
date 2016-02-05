/*
 * 从后往前dp。
 * 用一下滚动数组。
 * dp[i]表示到第i列的所需最小生命，它可以从dp[i]（下一行）和dp[i + 1]（右边）转移。
 * dp[i] = min(dp[i], dp[i + 1]) - cost[k][i];
 */

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null)
            return 0;
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[m - 1] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                dp[j] = Math.max(1, Math.min(dp[j], dp[j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0];
    }
}
