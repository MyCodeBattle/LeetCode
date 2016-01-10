/*
 * 题目要求常数空间复杂度，所以我们不能一开始就替换掉，先替换成一个其他的数字，然后最后换一遍。
 */

class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        if (matrix.empty())
            return;
        int n = matrix.size(), m = matrix[0].size();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) if (matrix[i][j] == 0) {
                for (int k = 0; k < m; k++) if (matrix[i][k] != 0)
                    matrix[i][k] = -0x3f3f3f3f;
                for (int k = 0; k < n; k++) if (matrix[k][j])
                    matrix[k][j] = -0x3f3f3f3f;
            }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) if (matrix[i][j] == -0x3f3f3f3f)
                matrix[i][j] = 0;
        return;
    }
};
