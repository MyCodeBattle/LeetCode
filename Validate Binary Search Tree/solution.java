/*
 * 限制一下最大值和最小值，dfs查找即可。
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

    boolean dfs(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (root.val >= maxValue || root.val <= minValue)
            return false;
        if (!dfs(root.left, minValue, root.val))
            return false;
        if (!dfs(root.right, root.val, maxValue))
            return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
