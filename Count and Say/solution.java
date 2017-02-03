public class Solution {
    public String countAndSay(int n) {
        --n;
        String[] ans = new String[2];
        ans[0] = "1"; ans[1] = "";
        int u = 0;
        while (n-- > 0) {
            int pos = 0;
            while (pos < ans[u].length()) {
                int mov = pos;
                while (mov + 1 < ans[u].length() && ans[u].charAt(pos) == ans[u].charAt(mov + 1))
                    ++mov;
                int len = mov - pos + 1;
                ans[u^1] += Integer.toString(len) + ans[u].charAt(pos);
                pos = mov + 1;
            }
            u ^= 1;
            ans[u^1] = "";
        }
        return ans[u];
    }
}

