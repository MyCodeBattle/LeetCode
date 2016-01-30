/*
 * dp[i]表示前i个字符能否组成。dp[i] = true if dp[i - len] = true and str(len, i) = 回文.
 */

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s.isEmpty())
            return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= i + 1; j++) {
                if (dp[i + 1 - j]) {
                    if (wordDict.contains(s.substring(i + 1 - j, i + 1))) {
                        dp[i + 1] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
