class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        tmp = x
        if x < 0:
            return False
        ret = 0
        while x:
            ret = ret*10 + x%10
            x /= 10
        return True if tmp == ret else False

