/*
 * 可以通过(i - 1, j), (i, j - 1), (i - 1, j -1)这三个点的最小值来获得能组成正方形的边长。
 */

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n + 1][m + 1];

        int ans = 0;
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= m; ++j) if (matrix[i - 1][j - 1] == '1') {
                dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                ans = Math.max(ans, dp[i][j]*dp[i][j]);
            }
        return ans;
                
    }
}
