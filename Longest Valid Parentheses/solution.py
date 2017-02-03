class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        stk = list()
        ans = 0
        for i in xrange(len(s)):
            if not stk:
                stk.append(i)
            else:
                if s[i] == ')' and s[stk[-1]] == '(':
                    stk.pop()
                    ans = max(ans, i - (-1 if not stk else stk[-1]))
                else:
                    stk.append(i)
        if not stk:
            ans = len(s)
        return ans
