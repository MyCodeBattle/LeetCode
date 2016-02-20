/*
 * 区间dp。
 * 如果我们考虑第一个数删的是谁，那么这时候数的邻居就会变化，这样就搞不出来了。
 * 考虑最后一个数删的是谁。那么我们肯定能得到nums[left]*nums[i]*nums[right]的值。left和right是左右边界。
 * 然后记忆化dp一下就行。
 */

public class Solution {
    int[][] dp;

    private int dfs(int l, int r, int[] nums) {
        if (l + 1 == r)
            return 0;
        if (dp[l + 1][r - 1] != -1)
            return dp[l + 1][r - 1];
        int ans = 0;
        for (int i = l + 1; i < r; ++i) {
            int left = l == -1 ? 1 : nums[l];
            int right = r == nums.length ? 1 : nums[r];
            ans = Math.max(ans, dfs(l, i, nums) + left*right*nums[i] + dfs(i, r, nums));
        }
        return dp[l + 1][r - 1] = ans;
    }

    public int maxCoins(int[] nums) {
        if (nums.length == 0)
            return 0;
        dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; ++i)
            Arrays.fill(dp[i], -1);
        return dfs(-1, nums.length, nums);
    }
}
