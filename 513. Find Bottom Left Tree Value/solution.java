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
    private int depth = 0;

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    private Integer dfs(TreeNode root, int dep) {
        if (root == null) {
            return null;
        }
        if (dep == depth) {
            return root.val;
        }
        Integer ans = dfs(root.left, dep + 1);
        if (ans != null) {
            return ans;
        }
        return dfs(root.right, dep + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        depth = getDepth(root);
        return dfs(root, 1);
    }
}
