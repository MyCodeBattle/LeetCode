public class Solution {
    long dividend, divisor;
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        this.dividend = dividend; this.divisor = divisor;
        int sign = 0;
        if (this.dividend < 0) {
            sign = 1;
            this.dividend = -this.dividend;
        }
        if (this.divisor < 0) {
            sign ^= 1;
            this.divisor = -this.divisor;
        }
        int ans = 0;
        while (this.dividend >= this.divisor) {
            long tempResult = this.divisor, mul = 1;
            while (this.dividend >= (tempResult<<1)) {
                tempResult <<= 1;
                mul <<= 1;
            }
            ans += mul;
            this.dividend -= tempResult;
        }
        return sign == 1 ? -ans : ans;
    }
}
