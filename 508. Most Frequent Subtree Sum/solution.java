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
    private Map<Integer, Integer> map = new HashMap<>();

    private int dfs(TreeNode rt) {

        if (rt == null) {
            return 0;
        }
        int curSum = dfs(rt.left) + dfs(rt.right) + rt.val;
        if (!map.containsKey(curSum)) {
            map.put(curSum, 0);
        }
        map.put(curSum, map.get(curSum) + 1);
        return curSum;
    }
        

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        dfs(root);

        List<Integer> lis = new ArrayList<>();
        int pos = 0;

        int maxCnt = 0, size = 0;
        for (int u : map.values()) {
            maxCnt = Math.max(u, maxCnt);
        }
        for (int u : map.values()) {
            if (u == maxCnt) {
                ++size;
            }
        }
        int[] ans = new int[size];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCnt) {
                ans[pos++] = entry.getKey();
            }
        }

        return ans;

    }
}
