public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = "";
        for (int u = 0; u < strs[0].length(); u++) {
            for (int i = 1; i < strs.length; i++) {
                if (u == strs[i].length()) {
                    return ans;
                }
                else if (strs[i].charAt(u) != strs[0].charAt(u)) {
                    return ans;
                }
            }
            ans += strs[0].charAt(u);
        }
        return ans;
    }
}
