/*
 * 跟前面那题一样单调栈，只是加了维护一个向上方向的值。up[i][j] = i == 0 ? 1 : up[i - 1][j] + 1。
 */

class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if (matrix.empty())
            return 0;
        int n = matrix.size(), m = matrix[0].size();
        int up[n][m] = {0}, left[n][m] = {0};
        int ans = 0;
        for (int i = 0; i < n; i++) {
            stack<int> stk;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    up[i][j] = i == 0 ? 1 : up[i - 1][j] + 1;
                    while (!stk.empty() && up[i][stk.top()] >= up[i][j])
                        stk.pop();
                    left[i][j] = stk.empty() ? j : j - stk.top() - 1;
                }
                else
                    up[i][j] = 0;
                stk.push(j);
            }
            while (!stk.empty())
                stk.pop();
            for (int j = m - 1; j > -1; j--) {
                if (matrix[i][j] == '1') {
                    while (!stk.empty() && up[i][stk.top()] >= up[i][j])
                        stk.pop();
                    int tmp = stk.empty() ? m - 1 - j : stk.top() - j - 1;
                    ans = max(ans, up[i][j] * (tmp + left[i][j] + 1));
                }
                stk.push(j);
            }
        }
        return ans;
    }
};
