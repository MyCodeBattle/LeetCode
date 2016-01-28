/*
 * 我们反着想一下，只要我们把闭不上的O都找出来，其余的O都可以被换成X。
 * 而闭不上的O很好找，只要从边界搜索一下就行。
 * 所以我们就扫描一下边界，替换一下能到达的O，然后替换掉封闭的O，最后替换回来。
 */

public class Solution {
    int n = 0;
    int m = 0;

    void fillTheRegion(int row, int column, char[][] board) {
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        board[row][column] = '*';
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(m*row + column);

        while (!Q.isEmpty()) {
            int currentRow = Q.peek() / m;
            int currentColumn = Q.peek() % m;
            Q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + dir[i][0];
                int nextColumn = currentColumn + dir[i][1];
                if (nextRow < 0 || nextRow == n || nextColumn < 0 || nextColumn == m)
                    continue;
                if (board[nextRow][nextColumn] == 'O') {
                    board[nextRow][nextColumn] = '*';
                    Q.offer(m*nextRow + nextColumn);
                }
            }
        }
    }

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0)
            return;
        m = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O')
                fillTheRegion(0, i, board);
            if (board[n - 1][i] == 'O')
                fillTheRegion(n - 1, i, board);
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                fillTheRegion(i, 0, board);
            if (board[i][m - 1] == 'O')
                fillTheRegion(i, m - 1, board);
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) if (board[i][j] == 'O')
                board[i][j] = 'X';
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) if (board[i][j] == '*')
                board[i][j] = 'O';
    }
}
