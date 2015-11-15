class Solution(object):
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        str = str.strip()
        if len(str) == 0:
            return 0
        ls = list(str)
        sign = -1 if ls[0] == '-' else 1
        if ls[0] in ['+', '-']:
            del ls[0]
        ret = 0
        pos = 0
        while pos < len(ls) and ls[pos].isdigit():
            ret = ret*10 + ord(ls[pos]) - ord('0')
            pos += 1
        return max(-2**31, min(2**31 - 1, sign * ret))

a = Solution()
