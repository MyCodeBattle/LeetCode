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

    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int ret = 0;
        if (root.left != null)
            ret = dfs(root.left);
        if (root.right != null) {
            if (ret == 0)
                ret = dfs(root.right);
            else 
                ret = Math.min(ret, dfs(root.right));
        }
        return ret + 1;
    }

    public int minDepth(TreeNode root) {
        return dfs(root);
    }
}
