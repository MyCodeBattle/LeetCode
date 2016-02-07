/*
 * 找连通块。搜一下。
 */

public class Solution {
    private int n, m;
    boolean[][] vis;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int bfs(int x, int y, char[][] grid) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(x*m + y);

        while (!Q.isEmpty()) {
            int xx = Q.peek() / m;
            int yy = Q.peek() % m;
            Q.poll();
            for (int i = 0; i < 4; ++i) {
                int u = xx + dir[i][0], v = yy + dir[i][1];
                if (u < 0 || u == n || v < 0 || v == m)
                    continue;
                if (vis[u][v] || grid[u][v] != '1')
                    continue;
                vis[u][v] = true;
                Q.offer(u*m + v);
            }
        }
        return 1;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];

        int ans = 0;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) if (!vis[i][j] && grid[i][j] == '1')
                ans += bfs(i, j, grid);
        return ans;
    }
}
