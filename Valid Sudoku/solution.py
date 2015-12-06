class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        vis1, vis2, vis3 = set(), set(), set()
        for i in xrange(len(board)):
            for j in xrange(len(board)):
                if board[i][j] != '.':
                    n = ord(board[i][j]) - ord('0')
                    grid = i/3*3 + j/3
                    if (i, n) in vis1 or (j, n) in vis2 or (grid, n) in vis3:
                        return False
                    vis1.add((i, n))
                    vis2.add((j, n))
                    vis3.add((grid, n))
        return True

