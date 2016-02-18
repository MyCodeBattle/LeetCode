/*
 * 容斥一下。我们用dp[i][j]表示1, 1到i, j的矩阵和。想象把鼠标从1, 1拖到i, j。。
 * 然后求某一个矩阵，可以用全部的减去他身边的那两块白的，因为左上那一块多减了一次，就加回来。
 */

public class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; ++i)
            for (int j = 1; j <= matrix[0].length; ++j)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        ++row1; ++row2; ++col1; ++col2;
        row1 = Math.max(0, row1); row2 = Math.max(0, row2);
        col1 = Math.min(dp[0].length, col1); col2 = Math.min(dp[0].length, col2);
        return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
