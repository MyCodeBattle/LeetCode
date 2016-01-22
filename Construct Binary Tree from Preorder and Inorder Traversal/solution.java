/*
 * 按顺序遍历先序数组，然后去中序里找，这个数的左边就是左子树，右边右子树，依次递归构造。
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
    int pos = -1;

    TreeNode dfs(int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (inStart >= inEnd)
            return null;
        ++pos;
        TreeNode currentNode = new TreeNode(preorder[pos]);
        for (int i = inStart; i < inEnd; ++i) {
            if (inorder[i] == preorder[pos]) {
                currentNode.left = dfs(inStart, i, preorder, inorder);
                currentNode.right = dfs(i + 1, inEnd, preorder, inorder);
                break;
            }
        }
        return currentNode;
    }
            
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, inorder.length, preorder, inorder);
    }
}
