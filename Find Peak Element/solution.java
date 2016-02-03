/*
 * 这个思想有点神奇。
 * 二分的时候，当nums[mid] > nums[mid + 1]的时候，我们可以知道左边一定存在一个答案。
 * 我是这么想的，假设nums[mid - 1]比nums[mid]小，显然mid就是答案。
 * 如果nums[mid - 1]比nums[mid]大，我们再去考虑mid - 1，最极端的情况就是一直比当前考虑的数大，当到第0位的时候，答案就在第0位。否则中途肯定会出一个答案。
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
