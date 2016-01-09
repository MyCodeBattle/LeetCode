/*
 * 分别讨论三种情况，取最小值。
 */

class Solution {
public:
    int minDistance(string word1, string word2) {
        int n = word1.size(), m = word2.size();
        int dp[n + 1][m + 1];
        memset(dp, 0, sizeof dp);
        for (int i = 1; i <= m; i++)
            dp[0][i] = i;
        for (int i = 1; i <= n; i++)
            dp[i][0] = i;
        //dp[i][j], 匹配到i-1, j-1。
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (word1[i - 1] == word2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(dp[i - 1][j - 1] + 1, min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        return dp[n][m];
    }
};
