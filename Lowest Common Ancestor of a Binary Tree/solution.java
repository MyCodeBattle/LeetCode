/*
 * 我们根据左孩子和右孩子的情况判断。
 * 如果左孩子找到一个：右孩子找到，LCA是root : 没找到，说明另一个点也在左孩子下面。
 * 左孩子找不到同理。
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p)
            return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        return leftNode == null ? rightNode : rightNode == null ? leftNode : root;
    }
}
