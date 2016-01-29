/*
 * 我们先从左到右扫描一遍，看每个数最少需要多少。
 * 然后再从右往左扫一遍，维护一下最大值。
 */

public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        int ans = 0;

        for (int i = 1; i < ratings.length; ++i)
            dp[i] = ratings[i] > ratings[i - 1] ? dp[i - 1] + 1 : 1;
        for (int i = ratings.length - 2; i > -1; --i) {
            dp[i] = Math.max(dp[i], ratings[i] > ratings[i + 1] ? dp[i + 1] + 1 : dp[i]);
            ans += dp[i];
        }
        return ans + dp[ratings.length - 1];
    }
}
        
