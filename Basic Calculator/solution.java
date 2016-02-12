/*
 * 用栈模拟，每碰到括号就把当前结果压入栈，当成一个新的开始。
 */

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNum = 0;
        int ans = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                if (c == '+') {
                    ans += sign*currentNum;
                    currentNum = 0;
                    sign = 1;
                }
                else if (c == '-') {
                    ans += sign*currentNum;
                    currentNum = 0;
                    sign = -1;
                }
                else if (c == '(') {
                    stack.push(ans);
                    stack.push(sign);
                    ans = 0;
                    sign = 1;
                }
                else if (c == ')') {
                    ans += sign*currentNum;
                    ans *= stack.pop();
                    ans += stack.pop();
                    currentNum = 0;
                }
            }
            else
                currentNum = currentNum*10 + c - '0';
        }
        if (currentNum != 0)
            ans += sign*currentNum;
        return ans;
    }
}
