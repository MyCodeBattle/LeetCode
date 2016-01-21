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

    boolean dfs(TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            if (l == null && r == null)
                return true;
            return false;
        }
        if (l.val != r.val)
            return false;
        if (!dfs(l.left, r.right))
            return false;
        return dfs(l.right, r.left);
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode l = root, r = root;
        return dfs(l, r);
    }
}
