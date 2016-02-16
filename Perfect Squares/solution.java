/*
 * 一般的方法是dp，O(nsqrt(n))。
 * 这个数学方法是O(sqrt(n))的。
 * Legendre's three-square theorem.
 */

public class Solution {
    private boolean isSquare(int n) {
        int m = (int) Math.sqrt(n + 0.5);
        return m*m == n;
    }

    public int numSquares(int n) {
        if (isSquare(n))
            return 1;

        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        int m = (int) Math.sqrt(n);
        for (int i = 1; i <= m; ++i) if (isSquare(n - i*i))
            return 2;
        return 3;
    }
}
