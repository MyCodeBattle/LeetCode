/*
 * 简单模拟。
 */

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if (tokens.length == 0)
            return 0;

        for (String str : tokens) {
            if (str.length() == 1 && !Character.isDigit(str.charAt(0))) {
                int v = stack.peek(); stack.pop();
                int u = stack.peek(); stack.pop();
                if (str.charAt(0) == '+')
                    stack.push(u + v);
                if (str.charAt(0) == '-')
                    stack.push(u - v);
                if (str.charAt(0) == '*')
                    stack.push(u * v);
                if (str.charAt(0) == '/')
                    stack.push(u / v);
            }
            else
                stack.push(Integer.parseInt(str));
        }
        return stack.peek();
    }
}
