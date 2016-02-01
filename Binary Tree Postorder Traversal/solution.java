/*
 * 观察可以发现，把从右子树开始的先序遍历反一下就是后序遍历。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        stack.push(root);

        TreeNode tempRoot = null;
        while (!stack.isEmpty()) {
            tempRoot = stack.peek();
            stack.pop();
            ans.add(tempRoot.val);
            if (tempRoot.left != null)
                stack.push(tempRoot.left);
            if (tempRoot.right != null)
                stack.push(tempRoot.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}
