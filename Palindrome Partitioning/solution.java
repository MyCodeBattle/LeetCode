/*
 * dp。dp[i] = dp[k] + str(k, i), k <= i。
 */

public class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        List<List<String>>[] result = new ArrayList[s.length() + 1];
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<>());

        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    String str = s.substring(j, i + 1);
                    for (List<String> lastResult : result[j]) {
                        List<String> currentResult = new ArrayList<>(lastResult);
                        currentResult.add(str);
                        result[i + 1].add(currentResult);
                    }
                }
            }
        }
        return result[s.length()];
    }
}
