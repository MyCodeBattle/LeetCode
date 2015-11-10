import Queue

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        mp = set()
        Q = Queue.Queue()
        ans = 0
        for i in xrange(len(s)):
            while s[i] in mp:
                mp.remove(Q.get())
            Q.put(s[i])
            mp.add(s[i])
            ans = max(ans, Q.qsize())
        return ans

