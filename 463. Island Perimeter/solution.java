public class Solution {
    private int ans = 0;
    private int n, m;
    boolean[][] vis;

    private static final int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int islandPerimeter(int[][] grid) {
        if (Objects.isNull(grid)) {
            return 0;
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        this.n = grid.length;
        this.m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) if (grid[i][j] == 1) {
                int cnt = 0;
                for (int k = 0; k < 4; ++k) {
                    int x = i + dir[k][0], y = j + dir[k][1];
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                        ++cnt;
                    }
                }
                ans += 4 - cnt;
            }
        }
        return ans;
    }
}
