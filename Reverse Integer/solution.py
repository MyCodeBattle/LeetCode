class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        ret = 0
        sign = 1
        if x < 0:
            sign = -1
            x *= sign
        while x:
            ret = ret*10 + abs(x % 10)
            x /= 10
        if ret > 2147483647 or ret < -2147483648:
            return 0
        return sign * ret


