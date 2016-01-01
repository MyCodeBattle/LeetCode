/*
 * 非常无聊的模拟题。
 */

class Solution {
public:
    int pos;
    string s;

    void erase_space() {
        for (pos = 0; pos < s.size() && isspace(s[pos]); ++pos);
        if (pos != s.size()) {
            if (s[pos] == '+' || s[pos] == '-')
                ++pos;
        }
        while (!s.empty() && isspace(s.back())) s.pop_back();
    }

    bool isNumber(string s) {
        this->s = s;
        bool used_dot = false, used_e = false, used_digit = false, after_digit = false;
        bool used_sign = false;
        //去空格
        erase_space();
        s = this->s;
        if (pos == s.size())
            return false;
        for (int i = pos; i < s.size(); i++) {
            if (s[i] == '.') {
                if (used_dot)
                    return false;
                if (used_e) 
                    return false;
                used_dot = true;
            }
            else if (s[i] == 'e') {
                if (used_e)
                    return false;
                used_e = true;
                if (!used_digit)
                    return false;
            }
            else if (isdigit(s[i])) {
                used_digit = true;
                if (used_e)
                    after_digit = true;
            }
            else if (s[i] == '-' || s[i] == '+') {
                if (used_sign || !used_e)
                    return false;
                used_sign = true;
            }
            else
                return false;
        }
        if (used_sign && (s.back() == '+' || s.back() == '-'))
            return false;
        if (used_e)
            return after_digit;
        return used_digit;
    }
};

