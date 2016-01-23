/*
 * 利用深度不可能为负数来传递子树的非法情况。
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

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = dfs(root.left), rightDepth = dfs(root.right);
        if (leftDepth == -1 || rightDepth == -1)
            return -1;
        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
}
