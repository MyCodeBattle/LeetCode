/*
 * 记忆化搜索。
 */

public class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] dp;
    int n, m;

    private int dfs(int x, int y, int[][] matrix) {
        if (dp[x][y] != 0)
            return dp[x][y];
        int ans = 1;
        for (int i = 0; i < 4; ++i) {
            int xx = x + dir[i][0], yy = y + dir[i][1];
            if (xx >= 0 && xx != n && yy >= 0 && yy != m && matrix[xx][yy] < matrix[x][y])
                ans = Math.max(ans, dfs(xx, yy, matrix) + 1);
        }
        return dp[x][y] = ans;
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];

        int ans = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                ans = Math.max(ans, dfs(i, j, matrix));
        return ans;
    }
}
