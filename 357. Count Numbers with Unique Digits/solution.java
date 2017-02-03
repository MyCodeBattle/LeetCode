/**
 * 数位 dp
 */
import java.util.Arrays;

public class Solution {
    int[][][] dp;

    int dfs(int pos, int state, int isZero) {
        if (pos < 0) {
            if (state == 0) {
                return 0;
            }
            return 1;
        }
        if (dp[pos][state][isZero] != -1) {
            return dp[pos][state][isZero];
        }

        int ans = 0;
        if (isZero == 1) {
            ans += dfs(pos - 1, state, 1);

        }
        for (int i = 0; i <= 9; ++i) if (((state >> i) & 1) == 0) {
            if (i == 0 && isZero == 1)
                continue;
            ans += dfs(pos - 1, state|(1<<i), 0);
        }
        return dp[pos][state][isZero] = ans;
    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        dp = new int[n][1<<10][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < (1<<10); ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(n - 1, 0, 1) + 1;
    }
}
