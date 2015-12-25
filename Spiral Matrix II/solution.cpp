/*
 * 和打印蛇形数一样。
 */

class Solution {
public:
    vector<vector<int>> ans;
    vector<vector<int>> generateMatrix(int n) {
        int dir[][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if (n == 0)
            return ans;
        int mat[n][n];
        int left = -1, right = n, up = -1, down = n;
        bool revised = true;
        int cnt = 0;
        int x = 0, y = -1;
        while (revised) {
            revised = false;
            for (int i = 0; i < 4; i++) {
                while (true) {
                    int xx = x + dir[i][0], yy = y + dir[i][1];
                    if (xx == up || xx == down || yy == left || yy == right) {
                        if (i == 0)
                            up = x;
                        else if (i == 1)
                            right = y;
                        else if (i == 2)
                            down = x;
                        else
                            left = y;
                        break;
                    }
                    mat[xx][yy] = ++cnt;
                    revised = true;
                    x = xx, y = yy;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans.push_back(vector<int>());
            for (int j = 0; j < n; j++)
                ans[i].push_back(mat[i][j]);
        }
        return ans;
    }
};

