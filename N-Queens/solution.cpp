/*
 * dfs + 回溯即可。
 * 可能是刚开始接触ACM的时候八皇后给我留下的阴影，导致现在看到八皇后就莫名慌。
 */

class Solution {
public:
    int n;
    vector<vector<string>> ans;
    void dfs(int cur_row, int v1, int v2, int v3, vector<string> mp) {
        if (cur_row == n) {
            ans.push_back(mp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((v1 & (1 << i)) || (v2 & (1 << (cur_row + i))) || (v3 & (1 << (cur_row - i + n - 1))))
                continue;
            mp[cur_row][i] = 'Q';
            dfs(cur_row + 1, v1 | (1 << i), v2 | (1 << (cur_row + i)), v3 | (1 << (cur_row - i + n - 1)), mp);
            mp[cur_row][i] = '.';
        }
    }

    vector<vector<string>> solveNQueens(int _n) {
        n = _n;
        vector<string> mp(n, string(n, '.'));
        dfs(0, 0, 0, 0, mp);
        return ans;
    }
};
