/*
 * 栈
 */

class Solution {
public:
    bool isValid(string s) {
        stack<int> stk;
        for (char cha : s) {
            if (stk.empty() && (cha == ']' || cha == ')' || cha == '}')) {
                return false;
            }
            if (cha == ']') {
                if (stk.top() != '[') {
                    return false;
                }
                stk.pop();
            }
            if (cha == ')') {
                if (stk.top() != '(') {
                    return false;
                }
                stk.pop();
            }
            if (cha == '}') {
                if (stk.top() != '{') {
                    return false;
                }
                stk.pop();
            }
            if (cha == '(' || cha == '{' || cha == '[') {
                stk.push(cha);
            }
        }
        return stk.empty();
    }
};
