class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        if not strs:
            return list(list())
        mp = dict()
        strs.sort()
        for string in strs:
            s = list(string)
            s.sort()
            new_str = ''.join(s)
            if not hash(new_str) in mp:
                mp[hash(new_str)] = list()
            mp[hash(new_str)].append(string)
        return list(mp.itervalues())

