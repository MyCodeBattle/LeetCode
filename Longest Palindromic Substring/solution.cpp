/*
 *  O(n^2)被卡，只能用马拉车。有几个人能在面试的时候完整地写下来？
 */
   

class Solution {
public:
    string str, ans;
    int **mp;

    int dfs(int l, int r) {
        if (l > r) {
            return true;
        }
        if (mp[l][r] != -1) return mp[l][r];
        mp[l][r] = 0;
        if (str[l] == str[r] && dfs(l+1, r-1)) {
            mp[l][r] = 1;
            if (r-l+1 > ans.size()) {
                ans = str.substr(l, r-l+1);
            }
        }
        dfs(l+1, r);
        dfs(l, r-1);
        return mp[l][r];
    }

    string longestPalindrome(string _s) {
        str = _s;
        if (_s.empty()) {
            return "";
        }
        int n = _s.size();
        mp = new int*[n];
        for (int i = 0; i < n; i++) {
            mp[i] = new int[n];
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) mp[i][j] = -1;
        dfs(0, _s.size()-1);
        return ans;
    }
};
