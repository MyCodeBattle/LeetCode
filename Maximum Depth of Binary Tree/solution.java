/*
 * 随便搞搞。
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
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
}
