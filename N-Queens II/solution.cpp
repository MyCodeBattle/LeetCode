/*
 * 和上题一样。
 */

class Solution {
public:
    int n, ans;

    void dfs(int cur_row, int v1, int v2, int v3) {
        if (cur_row == n) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((v1 & (1 << i)) || (v2 & (1 << (cur_row + i))) || (v3 & (1 << (cur_row - i + n - 1))))
                continue;
            dfs(cur_row + 1, v1 | (1 << i), v2 | (1 << (cur_row + i)), v3 | (1 << (cur_row - i + n - 1)));
        }
    }

    int totalNQueens(int _n) {
        n = _n; ans = 0;
        dfs(0, 0, 0, 0);
        return this->ans;
    }
};


