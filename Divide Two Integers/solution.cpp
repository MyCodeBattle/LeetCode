/*
 * 可以用位移的方法，相当于分解倍数。
 */

class Solution {
public:
    long long dividend, divisor;

    int divide(int dividend, int divisor) {
        if (!divisor || (dividend == INT_MIN && divisor == -1))
            return INT_MAX;
        this->dividend = dividend, this->divisor = divisor;
        int sign = 0;
        if (this->dividend < 0) {
            sign = 1;
            this->dividend = -this->dividend;
        }
        if (this->divisor < 0) {
            sign ^= 1;
            this->divisor = -this->divisor;
        }
        int ans = 0;
        while (this->dividend >= this->divisor) {
            long long tmp_res = this->divisor, mul = 1;
            while (this->dividend >= (tmp_res<<1))
            {
                tmp_res <<= 1;
                mul <<= 1;
            }
            this->dividend -= tmp_res;
            ans += mul;
        }
        return sign ? -ans : ans;
    }
};
