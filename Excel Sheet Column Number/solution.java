/*
 * 还是反着算。
 */

public class Solution {
    public int titleToNumber(String s) {
        int len = s.length() - 1;
        int ans = 0, weigh = 1;
        for (int i = s.length() - 1; i >= 0; --i) {
            int num = s.charAt(i) - 'A' + 1;
            ans += num * weigh;
            weigh *= 26;
        }
        return ans;
    }
}
