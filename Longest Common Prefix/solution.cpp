/*
 * 暴力统计即可
 */
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) {
            return "";
        }
        string ans;
        for (int u = 0; u < strs[0].size(); u++) {
            for (int i = 1; i < strs.size(); i++) {
                if (u == strs[i].size()) {
                    return ans;
                }
                if (strs[i][u] != strs[0][u]) {
                    return ans;
                }
            }
            ans += strs[0][u];
        }
        return ans;
    }
};
