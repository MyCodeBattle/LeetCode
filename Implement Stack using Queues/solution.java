/*
 * 每次push的时候重新倒一遍队列即可。
 */

class MyStack {
    Queue<Integer> Q = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        Q.offer(x);
        for (int i = 0; i < Q.size() - 1; ++i)
            Q.offer(Q.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        Q.poll();
    }

    // Get the top element.
    public int top() {
        return Q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return Q.isEmpty();
    }
}
