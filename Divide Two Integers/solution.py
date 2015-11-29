class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        if not divisor or (dividend == -2147483648 and divisor == -1):
            return 2147483647
        sign = 0
        if dividend < 0:
            sign = 1
            dividend = -dividend
        if divisor < 0:
            sign ^= 1
            divisor = -divisor
        ans = 0
        while dividend >= divisor:
            tmp_res = divisor
            mul = 1
            while dividend >= (tmp_res<<1):
                tmp_res <<= 1
                mul <<= 1
            dividend -= tmp_res
            ans += mul
        return -ans if sign else ans

