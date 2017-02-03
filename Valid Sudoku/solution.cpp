/*
 * 暴力扫描判断即可。
 * 有个小trick，就是判断一个3*3的格子里有没有重复的，可以用row/3*3 + column/3。
 * 因为我们观察一下就能知道，row每增加1，贡献了3个格子。
 */

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int len = board.size();
        bool vis1[10][10] = {0}, vis2[10][10] = {0}, vis3[10][10] = {0};
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.size(); j++) if (board[i][j] != '.') {
                int n = board[i][j] - '0';
                int grid = i/3*3 + j/3;
                if (vis1[i][n] || vis2[j][n] || vis3[grid][n])
                    return false;
                vis1[i][n] = vis2[j][n] = vis3[grid][n] = true;
            }
        }
        return true;
    }
};
