/*
 * 一题很神奇的贪心。
 * 我们记录下每个字母的出现位置，然后按顺序扫描。
 * 如果我们扫描到后面某个字母A的最大位置比当前字母的最小位置小，我们便可以得知当前如果选择这个字母并不一定是最优的，因为后面可能出现一个字母，能「掩盖」住A。所以我们放弃当前字母，继续寻找之后的字母。
 * 选中之后，我们要删除当前所选位置之前的全部数字。
 * 重复这个过程，直到全部选完。
 */

class Solution {
public:
    vector<int> G[30];
    vector<pair<int, int>>ans;

    string removeDuplicateLetters(string s) {
        int remain = 0;
        for (int i = 0; i < s.size(); i++) {
            if (G[s[i] - 'a'].empty())
                ++remain;
            G[s[i] - 'a'].push_back(i);
        }
        while (remain) {
            for (int j = 0; j < 26; j++) if (!G[j].empty()) {
                bool found = true;
                int idx = G[j][0];
                for (int k = j + 1; k < 26; k++) if (!G[k].empty()) {
                    if (idx > G[k].back()) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    ans.push_back({idx, j});
                    G[j].clear();
                    --remain;
                    for (int k = 0; k < 26; k++)
                        while (!G[k].empty() && G[k][0] < idx)
                            G[k].erase(G[k].begin());
                    break;
                }
            }
        }
        sort(ans.begin(), ans.end());
        string ret;
        for (auto i : ans)
            ret += char(i.second + 'a');
        return ret;
    }
};
