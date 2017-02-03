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
    private int[] ans = new int[0];
    private int totalAns = 0, maxCnt = 0, curCnt = 0, pos = 0;
    private Integer curVal;

    public int[] findMode(TreeNode root) {
        if (Objects.isNull(root)) {
            return ans;
        }

        dfs(root, false);
        ans = new int[maxCnt];
        return ans;
    }

    private void handle(int n, boolean isWork) {
        if (Objects.isNull(curVal)) {
            curVal = n;
        }
        if (n == curVal) {
            ++curCnt;
        }
        else {
            curCnt = 1;
            curVal = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            totalAns = 1;
        }
        else if (curCnt == maxCnt) {
            if (isWork) {
                ans[pos++] = n;
            }
            ++totalAns;
        }
    }

    private void dfs(TreeNode rt, boolean isWork) {
        if (Objects.isNull(rt)) {
            return;
        }
        dfs(rt.left, isWork);
        handle(rt.val, isWork);
        dfs(rt.right, isWork);
    }
}

