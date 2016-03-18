/*
 * 快速幂。
 */

class Solution {
public:
    double myPow(double x, int n) {
        long long m = n;
        int sign = 1;
        if (n < 0)
            sign = -1;
        m = abs((long long)n);
        double ret = 1;
        while (m) {
            if (m & 1)
                ret = ret * x;
            x = x * x;
            m >>= 1;
        }
        return sign < 0 ? 1 / ret : ret;
    }
};
