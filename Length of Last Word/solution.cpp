/*
 * 随便搞。
 */

class Solution {
public:
    int lengthOfLastWord(string s) {
        if (s.empty())
            return 0;
        int pos = s.size() - 1;
        while (pos >= 0 && s[pos] == ' ') --pos;
        string ans;
        while (pos >= 0 && !isspace(s[pos]))
            ans += s[pos--];
        return ans.size();
    }
};
