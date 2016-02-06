/*
 * 遍历一遍树，优先走右边的路，记录一下走过的高度即可。
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
    Set<Integer> vised = new HashSet<>();
    List<Integer> ans = new ArrayList<>();

    private void dfs(TreeNode root, int step) {
        if (root == null)
            return;
        if (!vised.contains(step)) {
            ans.add(root.val);
            vised.add(step);
        }
        dfs(root.right, step + 1);
        dfs(root.left, step + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return ans;
        dfs(root, 0);
        return ans;
    }
}
