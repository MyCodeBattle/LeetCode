/*
 * 暴力匹配。
 */

class Solution {
public:
    string haystack, needle;
    bool check(int pos) {
        for (int i = 0; i < this->needle.size(); i++) {
            if (i+pos == this->haystack.size())
                return false;
            if (this->haystack[i+pos] != this->needle[i])
                return false;
        }
        return true;
    }

    int strStr(string haystack, string needle) {
        if (haystack.empty() && needle.empty())
            return 0;
        this->haystack = haystack; this->needle = needle;
        for (int i = 0; i < haystack.size(); i++) {
            if (haystack.size()-i < needle.size())
                return -1;
            if (check(i))
                return i;
        }
        return -1;
    }
};
