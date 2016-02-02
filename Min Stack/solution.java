/*
 * 主要思路就是当碰到一个新的更小的数a时，在push这个数之前先垫上一个之前的最小数b，等到a被pop的时候他的下一个总是接下来的最小值。
 */

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private int minValue = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= minValue) {
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        if (stack.peek() == minValue) {
            stack.pop();
            minValue = stack.peek();
            stack.pop();
        }
        else
            stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
}

