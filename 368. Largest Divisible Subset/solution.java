/**
 * 排序后 dp.
 */

public class Solution {
    List<Integer> cps[];
    int[] nums;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        this.nums = nums;
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        cps = new ArrayList[nums.length];
        int ans = 0;
        int idx = -1;
        for (int i = nums.length - 1; i >= 0; --i) {
            dfs(i);
            if (ans < cps[i].size()) {
                ans = cps[i].size();
                idx = i;
            }
        }
        return cps[idx];
    }

    private void dfs(int pos) {
        if (cps[pos] != null) {
            return;
        }
        if (cps[pos] == null) {
            cps[pos] = new ArrayList<>();
        }
        int idx = -1;
        int ans = 0;
        for (int i = pos-1; i >= 0; --i) if (nums[pos] % nums[i] == 0) {
            dfs(i);
            if (ans < cps[i].size()) {
                ans = cps[i].size();
                idx = i;
            }
        }
        if (idx != -1) {
            cps[pos].addAll(cps[idx]);
        }
        cps[pos].add(nums[pos]);
    }
}
