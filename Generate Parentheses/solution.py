class Solution(object):
    def dfs(self, str, l, r):
        if not l and not r:
            self.ans.append(str)
            return
        if l:
            self.dfs(str+'(', l-1, r)
        if r > l:
            self.dfs(str+')', l, r-1)

    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        self.ans = []
        self.dfs('', n, n)
        return self.ans


