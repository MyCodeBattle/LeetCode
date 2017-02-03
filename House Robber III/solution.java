/*
 * 考虑dp。
 * 考虑单个结点。
 * 我们用dp[next][0], dp[next][1]表示他的孩子结点选不选，得到的最大值。
 * 那么，如果当前结点选的话，我们只能加上不选孩子结点的最大值。
 * 也就是dp[cur][1] = dp[left][0] + dp[right][0].
 * 如果不选当前结点，那么我们可以从孩子的两种情况中选大的来加，就是
 * dp[cur][0] = max(dp[left][0], dp[left][1]) + max(dp[right][0], dp[right][1]);
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
    static int cnt = 0;

    private int[] dfs(TreeNode root) {
        int[] curVal = {0, 0};
		//System.out.println("123");
        if (root.left != null) {
            int[] nextVal = dfs(root.left);
            curVal[0] = Math.max(nextVal[0], nextVal[1]);
            curVal[1] = nextVal[0];
        }
        if (root.right != null) {
            int[] nextVal = dfs(root.right);
            curVal[0] += Math.max(nextVal[0], nextVal[1]);
            curVal[1] += nextVal[0];
        }
		curVal[1] += root.val;
		
        return curVal;
    }

    public int rob(TreeNode root) {
        if (root == null) 
            return 0;
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
}
