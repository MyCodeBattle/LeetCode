/*
 * 模拟。空间复杂度O(n^2)。
 * O(1)的复杂度其实就是自己定义几个数字的意思，然后最后更新一下。
 */

public class Solution {
    int[][] nextBoard;
    int n, m;

    private void helper(int[][] board, int x, int y) {
        int lives = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(n - 1, x + 1); ++i) {
            for (int j = Math.max(0, y - 1); j <= Math.min(m - 1, y + 1); ++j) {
                if (i == x && j == y)
                    continue;
                lives += board[i][j];
            }
        }
        if (board[x][y] == 0) {
            if (lives == 3)
                nextBoard[x][y] = 1;
        }
        else {
            if (lives == 2 || lives == 3)
                nextBoard[x][y] = 1;
        }
    }

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        n = board.length; m = board[0].length;
        nextBoard = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j)
                helper(board, i, j);
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j)
                board[i][j] = nextBoard[i][j];
        }
    }
}
