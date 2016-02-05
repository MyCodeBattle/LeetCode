/*
 * 就是用一个栈模拟中序遍历。
 * 先走到最左边，然后每pop出一个就走到他的右子树的最左边，依次循环。
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private Stack<TreeNode> stack;

    private void handleNext(TreeNode curNode) {
        while (curNode != null) {
            stack.push(curNode);
            curNode = curNode.left;
        }
    }

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        handleNext(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int ret = stack.peek().val;
        TreeNode curNode = stack.pop();
        handleNext(curNode.right);
        return ret;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
