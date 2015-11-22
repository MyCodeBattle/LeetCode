public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            if (stk.empty() && (cha == ']' || cha == '}' || cha == ')')) {
                return false;
            }
            if (cha == ']') {
                if (stk.peek() != '[') {
                    return false;
                }
                stk.pop();
            }
            if (cha == ')') {
                if (stk.peek() != '(') {
                    return false;
                }
                stk.pop();
            }
            if (cha == '}') {
                if (stk.peek() != '{') {
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
}

