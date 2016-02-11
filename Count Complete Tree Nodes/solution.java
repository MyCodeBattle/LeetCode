/*
 * 我们可以每一步判断一下左子树和右子树的深度。
 * 如果左子树深度等于右子树，说明左子树是满的，然后去计算右子树。
 * 如果左子树深度大于右子树，说明左子树是缺的，加上右子树结点，计算左子树。
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

    int getHeight(TreeNode root) {
        return root == null ? -1 : 1 + getHeight(root.left);
    }

    public int countNodes(TreeNode root) {
        int height = getHeight(root);
        return height < 0 ? 0 : getHeight(root.right) == height - 1 ? (1 << height) + countNodes(root.right) : (1 << (height - 1)) + countNodes(root.left);
    }
}
