/*
 * 素数筛。
 */

public class Solution {

    public int countPrimes(int n) {
        if (n <= 1)
            return 0;
        int m = (int) Math.sqrt(n + 0.5);
        boolean[] vis = new boolean[n];

        int ans = 0;
        for (int i = 2; i <= m; ++i) if (!vis[i]) {
            for (int j = i*i; j < n; j += i)
                vis[j] = true;
        }
        for (int i = 2; i < n; ++i) if (!vis[i])
            ++ans;
        return ans;
    }
}
