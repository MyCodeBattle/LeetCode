/*
 * 普通递归。
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
    List<String> ans = new ArrayList<>();

    private void dfs(TreeNode root, String path) {
        if (root == null)
            return;
        String curString = path + (path.isEmpty() ? root.val + "" : "->" + root.val);
        if (root.left == null && root.right == null) {
            ans.add(curString);
            return;
        }
        dfs(root.left, curString);
        dfs(root.right, curString);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }
}
