/*
 * 二维数组上的双指针，太神了！
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int n = matrix.length, m = matrix[0].length;

        int row = 0, column = m - 1;
        while (column >= 0 && row < n) {
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] < target)
                ++row;
            else
                --column;
        }
        return false;
    }
}
