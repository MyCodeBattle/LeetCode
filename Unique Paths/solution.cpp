/*
 * 考虑从两个方向近来即可。
 */

class Solution {
public:
    int uniquePaths(int m, int n) {
        int mp[m+1][n+1] = {0};
        mp[1][1] = 1;
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                mp[i][j] = mp[i-1][j] + mp[i][j-1];
            }
        return mp[m][n];
    }
};
