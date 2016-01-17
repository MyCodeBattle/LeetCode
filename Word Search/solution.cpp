/*
 * dfs回溯。
 */

class Solution {
public:
    int n, m;
    string word;

    bool dfs(int x, int y, int pos, vector<vector<char>> &board) {
        static int dir[][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        if (pos == word.size() - 1)
            return true;
        for (int i = 0; i < 4; i++) {
            int xx = x + dir[i][0], yy = y + dir[i][1];
            if (xx < 0 || yy < 0 || xx == n || yy == m)
                continue;
            if (board[xx][yy] == '*' || board[xx][yy] != word[pos + 1])
                continue;
            board[xx][yy] = '*';
            if (dfs(xx, yy, pos + 1, board))
                return true;
            board[xx][yy] = word[pos + 1];
        }
        return false;
    }

    bool exist(vector<vector<char>>& board, string word) {
        if (word.empty() || board.empty())
            return false;
        this->word = word;
        n = board.size(), m = board[0].size();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) if (board[i][j] == word[0]) {
                board[i][j] = '*';
                if (dfs(i, j, 0, board))
                    return true;
                board[i][j] = word[0];
            }
        return false;
    }
};
