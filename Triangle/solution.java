/*
 * 递推。
 */

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty())
            return 0;
        int level = triangle.size();
        int[][] dp = new int[level][level];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < level; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < i + 1; j++) {
                if (j != i)
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                if (j != 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + triangle.get(i).get(j));
            }
        }
        int ans = dp[level - 1][0];
        for (int i = 0; i < level; i++)
            ans = Math.min(ans, dp[level - 1][i]);
        return ans;
    }
}
