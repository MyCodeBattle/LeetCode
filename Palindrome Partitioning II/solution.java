/*
 * 和上题方法一样。
 */

public class Solution {
    public int minCut(String s) {
        int[] dp = new int [s.length() + 1];
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j <= i; j++) if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPalindrome[j + 1][i - 1])) {
                isPalindrome[j][i] = true;
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
            }
        }
        return dp[s.length()] - 1;
    }
}
