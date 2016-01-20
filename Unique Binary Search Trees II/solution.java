/*
 * 分别以每个数为中心进行dfs，然后用当前结点接上左右子树。
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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return dfs(1, n);
    }

    List<TreeNode> dfs(int l, int r) {
        List<TreeNode> curTree = new ArrayList<>();
        if (l > r) {
            curTree.add(null);
            return curTree;
        }
        for (int i = l; i <= r; ++i) {
            List<TreeNode> leftTrees = dfs(l, i - 1);
            List<TreeNode> rightTrees = dfs(i + 1, r);
            for (TreeNode leftTreeNode : leftTrees) {
                for (TreeNode rightTreeNode : rightTrees) {
                    TreeNode tmpCurTreeNode = new TreeNode(i);
                    tmpCurTreeNode.left = leftTreeNode;
                    tmpCurTreeNode.right = rightTreeNode;
                    curTree.add(tmpCurTreeNode);
                }
            }
        }
        return curTree;
    }
}
