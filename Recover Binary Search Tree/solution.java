/*
 * 先左递归一次，然后判断前一个值是否 >= 当前值。如果是是的话说明第一个出现的前一个值是违法的，然后找它交换的位置。然后重复这个过程去找第二个违法的数，找到后交换即可。
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
    TreeNode firstElement = null, secondElement = null;
    TreeNode lastVal = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        dfs(root);
        int tmp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = tmp;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (root.val <= lastVal.val) {
            if (firstElement == null)
                firstElement = lastVal;
            if (firstElement != null)
                secondElement = root;
        }
        lastVal = root;
        dfs(root.right);
    }
}
