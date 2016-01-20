/*
 * dp[i][j]表示第i位3字符串匹配了第j位1字符串。
 * 然后考虑这个状态的转移，可以由前一个1字符串或者3字符串转移过来。
 * 注意一下范围即可。
 */

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        boolean[][] dp = new boolean[len3 + 1][len1 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len3; i++) {
            for (int j = 0; j <= Math.min(i, len1); j++) {
                int otherLen = i - j;
                if (otherLen >= 1 && otherLen - 1 < len2 && dp[i - 1][j] && s2.charAt(otherLen - 1) == s3.charAt(i - 1))
                    dp[i][j] = true;
                else if (j != 0) {
                    if (dp[i - 1][j - 1] && s1.charAt(j - 1) == s3.charAt(i - 1))
                        dp[i][j] = true;
                }
            }
        }
        return dp[len3][len1];
    }
}
