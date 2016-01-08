/*
 * Fibonacci数列。
 */

class Solution {
public:
    int climbStairs(int n) {
        int dp[100];
        memset(dp, 0, sizeof dp);
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
};
