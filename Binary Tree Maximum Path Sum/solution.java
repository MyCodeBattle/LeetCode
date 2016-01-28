/*
 * 考虑dfs(node)是以当前结点为LCA的最长路径。
 * 那么便是从左子树和右子树中选一条值大的，加上当前结点的值。
 * 因为有可能是断的，所以要每步维护一下最大值。
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
    int ans = Integer.MIN_VALUE;

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftValue = dfs(root.left), rightValue = dfs(root.right);
        leftValue = Math.max(0, leftValue);
        rightValue = Math.max(0, rightValue);
        ans = Math.max(ans, leftValue + rightValue + root.val);
        return Math.max(leftValue, rightValue) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}
