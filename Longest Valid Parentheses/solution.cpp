/*
 * 和括号匹配一样，用一个栈去匹配括号，只不过改成push的是序号。如果遇到不能匹配的就直接放在栈里。
 * 最后我们从栈里取出来的，少掉的长度就是最长的能匹配的长度！
 * Amazing!!
 */

class Solution {
public:
    stack<int> stk;

    int longestValidParentheses(string s) {
        for (int i = 0; i < s.size(); i++) {
            if (stk.empty())
                stk.push(i);
            else {
                if (s[i] == ')' && s[stk.top()] == '(')
                    stk.pop();
                else
                    stk.push(i);
            }
        }
        int pos = s.size(), ans = 0;
        if (stk.empty())
            ans = pos;
        while (!stk.empty()) {
            int u = stk.top();
            stk.pop();
            ans = max(ans, pos - (u + 1));
            pos = u;
        }
        return max(ans, pos);
    }
};
