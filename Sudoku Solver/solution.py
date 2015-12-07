class Solution(object):

    def dfs(self, row, column, board):
        if row == 9:
            return True
        next_row = row + (column + 1) / self.n
        next_column = (column + 1) % self.n
        grid = row/3*3 + column/3
        if board[row][column] == '.':
            for i in range(1, 10):
                if (row, i) in self.vis1 or (column, i) in self.vis2 or (grid, i) in self.vis3:
                    continue
                self.vis1.add((row, i))
                self.vis2.add((column, i))
                self.vis3.add((grid, i))
                board[row][column] = chr(i + ord('0'))
                if self.dfs(next_row, next_column, board):
                    return True
                self.vis1.remove((row, i))
                self.vis2.remove((column, i))
                self.vis3.remove((grid, i))
                board[row][column] = '.'
            return False
        else:
            if self.dfs(next_row, next_column, board):
                return True
            return False

    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        self.vis1, self.vis2, self.vis3 = set(), set(), set()
        self.n = 9
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    u = ord(board[i][j]) - ord('0')
                    self.vis1.add((i, u))
                    self.vis2.add((j, u))
                    self.vis3.add((i/3*3 + j/3, u))
        self.dfs(0, 0, board)
        

