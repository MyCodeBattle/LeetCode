/*
 * dfs回溯，特判一下前导0。
 */

public class Solution {

    List<String> ans = new ArrayList<>();

    void dfs(String s, String curAddress, int count) {
        if (count > 4)
            return;
        for (int i = 1; i <= Math.min(s.length(), 3); i++) {
            if (Integer.parseInt(s.substring(0, i)) <= 255) {
                if (i != 1 && s.charAt(0) == '0')
                    continue;
                if (i != s.length())
                    dfs(s.substring(i), curAddress + s.substring(0, i) + ".", count + 1);
                else {
                    if (count == 4)
                        ans.add(curAddress + s.substring(0, i));
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        dfs(s, "", 1);
        return ans;
    }
}
