/*
 * 这题基本的递推是dp[i] = dp[i - 1] + condition ? dp[i - 2] : 0。
 * 考虑当前字符，它可以单独放在前面的集合的后面，就是dp[i - 1]，如果他和前面那一位可以形成两位，就可以放在dp[i - 2]集合后面。
 * 然而题意没有讲清楚0是怎么算的。
 * 看了题解，0只能当做10、20。其他不算。
 */

public class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty())
            return 0;
        int[] dp = new int[s.length() + 1];
        int len = s.length();
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        for (int i = len - 2; i >= 0; --i) {
            if (s.charAt(i) == '0')
                continue;
            dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
        }
        return dp[0];
    }
}
