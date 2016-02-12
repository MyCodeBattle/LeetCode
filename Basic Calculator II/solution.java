/*
 * 保存一下上一个运算符，如果是乘除的话从栈里取出来运算再放进去，如果是加减的话直接放进去。
 * 其实如果是加减也可以取一个运算放进去，不过要判断一下当前的操作符。还不如直接放进去。
 */

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char lastOperator = '+';
        int currentNumber = 0;
        s += '-';

        for (int i = 0; i < s.length(); ++i) if (!Character.isSpaceChar(s.charAt(i))) {
            char u = s.charAt(i);
            if (!Character.isDigit(u)) {
                if (lastOperator == '*')
                    stack.push(stack.pop()*currentNumber);
                else if (lastOperator == '/')
                    stack.push(stack.pop()/currentNumber);
                else if (lastOperator == '+')
                    stack.push(currentNumber);
                else if (lastOperator == '-')
                    stack.push(-currentNumber);
                currentNumber = 0;
                lastOperator = u;
            }
            else
                currentNumber = currentNumber*10 + u - '0';
        }
        int ans = 0;
        while (!stack.isEmpty())
            ans += stack.pop();
        return ans;
    }
}
