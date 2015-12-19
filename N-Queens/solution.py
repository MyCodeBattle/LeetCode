class Solution(object):
    def dfs(self, cur_row, v1, v2, v3, mp):
        if cur_row == self.n:
            self.ans.append(copy.copy(mp))
            return
        for i in range(self.n):
            if (v1 & (1 << i)) or (v2 & (1 << (cur_row + i))) or (v3 & (1 << (cur_row - i + self.n - 1))):
                continue
            s = ''
            for j in range(self.n):
                s += '.' if j != i else 'Q'
            mp.append(s)
            self.dfs(cur_row + 1, v1 | (1 << i), v2 | (1 << (cur_row + i)), v3 | (1 << (cur_row - i + self.n - 1)), mp)
            mp.pop()

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.ans = []
        self.n = n
        self.dfs(0, 0, 0, 0, [])
        return self.ans

