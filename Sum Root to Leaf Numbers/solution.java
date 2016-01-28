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
    int ans = 0;

    void dfs(TreeNode root, int currentSum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans += currentSum*10 + root.val;
            return;
        }
        else {
            if (root.left != null)
                dfs(root.left, currentSum*10 + root.val);
            if (root.right != null)
                dfs(root.right, currentSum*10 + root.val);
        }
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
}
