public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        boolean[][] vis1 = new boolean[10][10], vis2 = new boolean[10][10], vis3 = new boolean[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) if (board[i][j] != '.') {
                int n = board[i][j] - '0';
                int grid = i/3*3 + j/3;
                if (vis1[i][n] == true || vis2[j][n] == true || vis3[grid][n] == true)
                    return false;
                vis1[i][n] = vis2[j][n] = vis3[grid][n] = true;
            }
        }
        return true;
    }
}
