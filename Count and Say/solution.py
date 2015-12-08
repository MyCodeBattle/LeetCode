class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        ans = ['1', '']
        n -= 1
        u = 0
        while n:
            n -= 1
            pos = 0
            while pos < len(ans[u]):
                mov = pos
                while mov + 1 < len(ans[u]) and ans[u][mov + 1] == ans[u][pos]:
                    mov += 1
                l = mov - pos + 1
                ans[u^1] += chr(l + ord('0')) + ans[u][pos]
                pos = mov + 1
            u ^= 1
            ans[u^1] = ''
        return ans[u]

