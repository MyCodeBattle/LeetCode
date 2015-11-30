class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        ans = []
        mp = {}
        if not words:
            return ans
        length = len(words[0])
        for string in words:
            v = mp[string] if string in mp else 0
            v += 1
            mp[string] = v
        for i in xrange(len(words[0])):
            l = i
            r = i
            cnt = 0
            used = {}
            while r < len(s):
                if cnt < len(words):
                    if r + length - 1 >= len(s):
                        break
                    sub = s[r:r+length]
                    if sub not in mp:   
                        r += length
                        l = r
                        used.clear()
                        cnt = 0
                    else:
                        v = used[sub] if sub in used else 0
                        v += 1
                        if v > mp[sub]:
                            used[s[l:l+length]] = used[s[l:l+length]] - 1
                            l += length
                            cnt -= 1
                        else:
                            cnt += 1
                            used[sub] = v
                            r += length
                            if cnt == len(words):
                                ans.append(l)
                                used[s[l:l+length]] = used[s[l:l+length]] - 1
                                l += length
                                cnt -= 1
                elif (r - l) == len(words) * length:
                    used[s[l:l+length]] = used[s[l:l+length]] - 1
                    l += length
                    cnt -= 1
        return ans;
