/*
 * 预处理一下已经存在的信息，然后用上一题的方法判重，暴力回溯即可。
 * 这题让我想起了CCPC的一题完全一样的题。当时直接写傻了。
 * 给我带来了深深的阴影_(:3」∠)_
 */

class Solution {
public:

    int **vis1, **vis2, **vis3;
    int n;

    bool dfs(int row, int column, std::vector<vector<char>> &board) {
        if (row == 9)
            return true;
        int next_row = row + (column + 1) / 9;
        int next_column = (column + 1) % 9;
        int grid = row/3*3 + column/3;
        if (board[row][column] == '.') {
            for (int i = 1; i < 10; i++) {
                if (vis1[row][i] || vis2[column][i] || vis3[grid][i])
                    continue;
                vis1[row][i] = vis2[column][i] = vis3[grid][i] = 1;
                board[row][column] = i + '0';
                if (dfs(next_row, next_column, board))
                    return true;
                vis1[row][i] = vis2[column][i] = vis3[grid][i] = 0;
                board[row][column] = '.';
            }
            return false;
        }
        else {
            if (dfs(next_row, next_column, board))
                return true;
            return false;
        }
    }

    void solveSudoku(std::vector<vector<char>> &board) {
        n = 10;
        vis1 = new int*[n], vis2 = new int*[n], vis3 = new int*[n];
        for (int i = 0; i < n; i++) {
            vis1[i] = new int[n];
            vis2[i] = new int[n];
            vis3[i] = new int[n];
          //  for (int j = 0; j < n; j++) vis1[i][j] = vis2[i][j] = vis3[i][j] = 0;
        }
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) if (board[i][j] != '.') {
                int u = board[i][j] - '0';
                int grid = i/3*3 + j/3;
                vis1[i][u] = vis2[j][u] = vis3[grid][u] = 1;
            }
        dfs(0, 0, board);
    }
};
