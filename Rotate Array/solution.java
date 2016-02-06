/*
 * 三次reverse。
 */

public class Solution {

    private void reverse(int l, int r, int[] nums) {
        if (l == r)
            return;
        int left = l, right = r - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            ++left; --right;
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums.length == 0)
            return;
        k %= nums.length;
        reverse(0, nums.length - k, nums);
        reverse(nums.length - k, nums.length, nums);
        reverse(0, nums.length, nums);
    }
}
