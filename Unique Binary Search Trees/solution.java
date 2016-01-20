/*
 * 考虑dp[i]为i个点的子树形态和。
 * 那么dp[i]就是(左子树的情况 * 右子树情况)的和。
 * 左子树的情况就是左子树上有多少个点。
 */

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) 
            for (int j = 1; j <= i; j++)
                dp[i] += dp[j - 1] * dp[i - j];
        return dp[n];
    }
}
