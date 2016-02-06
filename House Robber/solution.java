/*
 * 我们先假设dp[i][0]表示到第i个不抢劫。
 * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
 * dp[i][1] = dp[i - 1][0] + nums[i];
 * 所以每次的维护之和上一个变量的选和不选有关。
 * 因此我们就可以直接用两个变量维护。
 */

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        int select = 0, unSelect = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            int currentUnSelect = Math.max(select, unSelect);
            int currentSelect = nums[i] + unSelect;
            select = currentSelect;
            unSelect = currentUnSelect;
            ans = Math.max(ans, Math.max(currentUnSelect, currentSelect));
        }
        return ans;
    }
}
