/*
 * 模拟。
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        stack.push(root);

        TreeNode tempRoot = root;
        while (!stack.isEmpty()) {
            tempRoot = stack.peek();
            stack.pop();
            ans.add(tempRoot.val);
            if (tempRoot.right != null) 
                stack.push(tempRoot.right);
            if (tempRoot.left != null) 
                stack.push(tempRoot.left);
        }
        return ans;
    }
}
