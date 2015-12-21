/*
 * 用了O(n^2)的空间复杂度，其实可以用四个变量记录一下边界。
 */

class Solution {
public:
    vector<int> ans;

    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        if (matrix.empty())
            return ans;
        int dir[][2] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int row = matrix.size(), col = matrix[0].size();
        bool vis[row][col];
        memset(vis, 0, sizeof vis);
        int x = 0, y = -1;
        bool revised = true;
        while (revised) {
            revised = false;
            for (int i = 0; i < 4; i++) {
                while (true) {
                    int xx = x + dir[i][0], yy = y + dir[i][1];
                    if (xx == row || yy == col || xx < 0 || yy < 0)
                        break;
                    if (vis[xx][yy])
                        break;
                    revised = true;
                    vis[xx][yy] = true;
                    ans.push_back(matrix[xx][yy]);
                    x = xx, y = yy;
                }
            }
        }
        return ans;
    }
};
