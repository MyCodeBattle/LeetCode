public class Solution {
    int[][] e = null;
    int ans = -1;
    int[] dp = null;

    public int maxEnvelopes(int[][] te) {
        if (te.length == 0)
            return 0;

        dp = new int[te.length];
        e = te;

        Arrays.sort(te, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < e.length; ++i) {
            dfs(i);
        }
        return ans;
    }

    private int dfs(int u) {
        if (dp[u] != 0) {
            return dp[u];
        }

        int tmp = 1;
        for (int i = u+1; i < e.length; ++i) if (e[i][0] > e[u][0] && e[i][1] > e[u][1]) {
            tmp = Math.max(tmp, dfs(i) + 1);
        }
        ans = Math.max(ans, tmp);
        return dp[u] = tmp;
    }
}



