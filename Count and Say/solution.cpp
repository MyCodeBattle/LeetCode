/*
 * 这题的题意真是。。
 * O(n * m)暴力即可。
 */

class Solution {
public:
    string ans[2];
    string countAndSay(int n) {
        --n;
        ans[0] = "1";
        int u = 0;
        while (n--) {
            int pos = 0;
            while (pos < ans[u].size()) {
                int mov = pos;
                while (mov + 1 < ans[u].size() && ans[u][mov + 1] == ans[u][pos])
                    ++mov;
                int len = mov - pos + 1;
                ans[u^1] += char(len + '0');
                ans[u^1] += ans[u][pos];
                pos = mov + 1;
            }
            u ^= 1;
            ans[u^1].clear();
        }
        return ans[u];
    }
};



