/*
 * 就是模拟中序遍历一下，看现在是第几大了。
 * 如果什么信息都不维护的话，只能是O(n)。
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
    int count, k;

    private TreeNode dfs(TreeNode root) {
        if (root == null)
            return null;
        TreeNode ret = dfs(root.left);
        if (ret != null)
            return ret;
        ++count;
        if (count == k)
            return root;
        ret = dfs(root.right);
        return ret;
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root).val;
    }
}
