/*
 * 之前一题的简化版。
 */

public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }
        return arr[l];
    }
}
