/*
 * 和上一题一样。
 */

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        if (obstacleGrid.empty() || obstacleGrid[0][0] == 1)
            return 0;
        int n = obstacleGrid.size(), m = obstacleGrid[0].size();
        int dp[n+1][m+1];
        memset(dp, 0, sizeof dp);
        dp[0][0] = 1;
        for (int i = 0; i < obstacleGrid.size(); i++) {
            for (int j = 0; j < obstacleGrid[0].size(); j++) if (obstacleGrid[i][j] == 0) {
                if (i) dp[i][j] = max(dp[i][j], dp[i-1][j]);
                if (j) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[obstacleGrid.size() - 1][obstacleGrid[0].size() - 1];
    }
};

