/*
 * 我们用right来表示当前已经可以表示出[0, right)的数。
 * 如果nums[i] <= right，说明我们可以一直表示到[0, nums[i] + right)。
 * 如果nums[i] > right，那么我们必须把这个数放进去，然后可以表示到[0, right*2]。
 */

public class Solution {
    public int minPatches(int[] nums, int n) {
        long right = 1;
        int ans = 0;
        int pos = 0;
        while (right <= n) {
            if (pos < nums.length && nums[pos] <= right)
                right += nums[pos++];
            else {
                right *= 2;
                ++ans;
            }
        }
        return ans;
    }
}
