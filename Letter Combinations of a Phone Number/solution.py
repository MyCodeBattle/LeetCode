class Solution(object):

    words = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];

    def dfs(self, pos, cur_ans):
        if pos == len(self.digits):
            self.ans.append(cur_ans)
            return
        for cha in self.words[ord(self.digits[pos]) - ord('0')]:
            self.dfs(pos + 1, cur_ans + cha)

    def letterCombinations(self, _digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        self.digits = _digits
        self.ans = []
        if not self.digits:
            return self.ans
        self.dfs(0, '')
        return self.ans

