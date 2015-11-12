class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        ans = ''
        if numRows == 0:
            return ans
        elif numRows == 1:
            return s
        for i in xrange(numRows):
            cnt = 0
            j = i
            while j < len(s):
                if i == numRows - 1 and not (cnt & 1):
                    cnt += 1
                elif i == 0 and (cnt & 1):
                    cnt += 1
                ans += s[j]
                cnt += 1
                j += (numRows - 1 - i) * 2 if cnt & 1 else i * 2
        return ans



