/*
 * 什么剪枝都不用，直接爆搜。
 */

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> currentAns = new ArrayList<>();

    private void dfs(int k, int pos, int sum) {
        if (k == 0) {
            if (sum == 0)
                ans.add(new ArrayList<>(currentAns));
            return;
        }
        for (int i = pos; i <= Math.min(9, sum); ++i) {
            currentAns.add(i);
            dfs(k - 1, i + 1, sum - i);
            currentAns.remove(currentAns.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, 1, n);
        return ans;
    }
}
