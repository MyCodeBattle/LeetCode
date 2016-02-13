/*
 * 从上往下走，第一个分叉就是LCA。
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
        TreeNode currentNode = root;
        while (true) {
            if ((currentNode.val - p.val) * (currentNode.val - q.val) <= 0)
                return currentNode;
            currentNode = currentNode.val > p.val ? currentNode.left : currentNode.right;
        }
    }
}
