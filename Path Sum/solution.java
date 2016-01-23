/*
 * 随便搞一下。
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

    int target = 0;

    boolean dfs(TreeNode root, int sum) {
        if (root.left != null || root.right != null) {
            if (root.left != null && dfs(root.left, sum + root.val))
                return true;
            if (root.right != null && dfs(root.right, sum + root.val))
                return true;
            return false;
        }
        return sum + root.val == target;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        target = sum;
        return dfs(root, 0);
    }
}
