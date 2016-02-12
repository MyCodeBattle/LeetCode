/*
 * 啊注意比较的时候可能会爆int。
 */

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0)
            return ans;

        int beginNumber = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if ((long) nums[i] - nums[i - 1] > 1L) {
                ans.add(beginNumber + (nums[i - 1] == beginNumber ? "" : "->" + nums[i - 1]));
                beginNumber = nums[i];
            }
        }
        ans.add(beginNumber + (nums[nums.length - 1] == beginNumber ? "" : "->" + nums[nums.length - 1]));
        return ans;
    }
}
