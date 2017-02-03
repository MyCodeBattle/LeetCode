public class Solution {
    
    boolean[][] vis1, vis2, vis3;
    int n;

    boolean dfs(int row, int column, char[][] board) {
        if (row == 9)
            return true;
        int next_row = row + (column + 1) / n;
        int next_column = (column + 1) % n;
        int grid = row/3*3 + column/3;
        if (board[row][column] == '.') {
            for (int i = 1; i < 10; i++) {
                if (vis1[row][i] || vis2[column][i] || vis3[grid][i])
                    continue;
                vis1[row][i] = vis2[column][i] = vis3[grid][i] = true;
                board[row][column] = (char)(Character.valueOf('0') + i);
                if (dfs(next_row, next_column, board))
                    return true;
                vis1[row][i] = vis2[column][i] = vis3[grid][i] = false;
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

    public void solveSudoku(char[][] board) {
        n = 9;
        vis1 = new boolean[10][10]; vis2 = new boolean[10][10]; vis3 = new boolean[10][10];
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) if (board[i][j] != '.') {
                int u = Character.valueOf(board[i][j]) - Character.valueOf('0');
                int grid = i/3*3 + j/3;
                vis1[i][u] = vis2[j][u] = vis3[grid][u] = true;
            }
        dfs(0, 0, board);
    }
}
