/*
 * 主要和上题都差不多，不过有个小trick。
 * 我们首先要判断这个字符串是不是可以分割的。
 * 不然前面分割得累死累活，后面发现根本分不了。
 * 有些人是倒过来写dp的，就AC了，这纯粹是测试数据的关系。完！全！没！有！道！理！
 */

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>[] tmpAns = new ArrayList[s.length() + 1];
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        tmpAns[0] = new ArrayList<>();

        if (s.isEmpty())
            return tmpAns[0];

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
        if (!dp[s.length()])
            return tmpAns[0];

        for (int i = 0; i < s.length(); ++i) {
            tmpAns[i + 1] = new ArrayList<>();

            for (int j = 1; j <= i + 1; ++j) {
                if (!tmpAns[i + 1 - j].isEmpty() || i + 1 - j == 0) {
                    if (wordDict.contains(s.substring(i + 1 - j, i + 1))) {
                        String currentSubstring = s.substring(i + 1 - j, i + 1);
                        for (String previousString : tmpAns[i + 1 - j])
                            tmpAns[i + 1].add(previousString + " " + currentSubstring);
                        if (i + 1 - j == 0)
                            tmpAns[i + 1].add(currentSubstring);
                    }
                }
            }
        }
        return tmpAns[s.length()];
    }
}

