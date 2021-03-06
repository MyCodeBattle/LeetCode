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

    boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null && q != null)
            return false;
        if (p != null && q == null)
            return false;
        if (p.val != q.val)
            return false;
        if (!dfs(p.left, q.left))
            return false;
        return dfs(p.right, q.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }
}
