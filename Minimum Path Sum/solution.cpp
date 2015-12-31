/*
 * 和上一题一样。
 */

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.empty())
            return 0;
        int n = grid.size(), m = grid[0].size();
        int dp[n + 1][m + 1];
        memset(dp, 0x3f, sizeof dp);
        dp[0][0] = grid[0][0];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
            {
                if (i) dp[i][j] = min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                if (j) dp[i][j] = min(dp[i][j], dp[i][j - 1] + grid[i][j]);
            }
        return dp[n - 1][m - 1];
    }
};
