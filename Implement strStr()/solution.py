class Solution(object):
    def check(self, pos):
        for i in xrange(len(self.needle)):
            if i+pos == len(self.haystack):
                return False
            if self.haystack[i+pos] != self.needle[i]:
                return False
        return True

    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        self.haystack = haystack
        self.needle = needle
        if not haystack and not needle:
            return 0
        for i in xrange(len(haystack)):
            if len(haystack)-i < len(needle):
                return -1
            if self.check(i):
                return i
        return -1

