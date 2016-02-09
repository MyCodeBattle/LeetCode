/*
 * 我们可以这么考虑。
 * 现在变成了环形，唯一的区别就是当洗劫了第一个的时候，最后一个是不能洗劫的。
 * 所以我们就取一下两种情况的最大值就行：
 * 1. 洗劫第一个家，去掉最后一个。
 * 2. 不洗第二个，可以洗最后一个。
 */

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    public int rob(int[] nums, int start, int end) {
        if (nums.length == 0)
            return 0;

        int select = 0, unSelect = 0;
        int ans = 0;
        for (int i = start; i <= end; ++i) {
            int currentUnSelect = Math.max(select, unSelect);
            int currentSelect = nums[i] + unSelect;
            select = currentSelect;
            unSelect = currentUnSelect;
            ans = Math.max(ans, Math.max(currentUnSelect, currentSelect));
        }
        return ans;
    }
}
