/*
 * 我们利用output数组来保存后缀连续乘积，用一个变量保存前缀连续乘积。
 * 那么一个数的answer就等于前缀乘积 * 后缀乘积。
 * 空间复杂度O(1)。
 */

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        if (nums.length == 1) {
            ans[0] = nums[0];
            return ans;
        }
        ans[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i)
            ans[i] = ans[i + 1]*nums[i];
        int product = nums[0];
        ans[0] = ans[1];
        for (int i = 1; i < nums.length - 1; ++i) {
            ans[i] = product*ans[i + 1];
            product *= nums[i];
        }
        ans[nums.length - 1] = product;
        return ans;
    }
}
