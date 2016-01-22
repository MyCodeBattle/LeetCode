/*
 * 和上题完全一样，只是从postorder后面开始找。
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
    int pos = 0;

    TreeNode dfs(int start, int end, int[] inorder, int[] postorder) {
        if (start >= end)
            return null;
        --pos;
        TreeNode currentNode = new TreeNode(postorder[pos]);
        for (int i = start; i < end; ++i) {
            if (postorder[pos] == inorder[i]) {
                currentNode.right = dfs(i + 1, end, inorder, postorder);
                currentNode.left = dfs(start, i, inorder, postorder);
                break;
            }
        }
        return currentNode;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos = postorder.length;
        return dfs(0, inorder.length, inorder, postorder);
    }
}
