/*
 * dp[i][j]表示前i个s能匹配几个前j个t。
 * 考虑这个状态的转移。
 * 不管怎么样，都可以从dp[i-1][j]处转移。
 * 如果当前字符相同的话，就可以从dp[i-1][j-1]转移。
 * 就是酱紫。
 */

public class Solution {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
            for (int j = 0; j < t.length(); j++) {
                dp[i + 1][j + 1] = dp[i][j + 1];
                if (s.charAt(i) == t.charAt(j))
                    dp[i + 1][j + 1] += dp[i][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}

