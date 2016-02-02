/*
 * 只要在上题的基础上加一下相等的时候r--即可。我这里多加的那一个条件是为了找出真正数组的第一个位置。
 */

public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] > nums[r])
                l = mid + 1;
            else if (nums[mid] < nums[r])
                r = mid;
            else if (nums[r - 1] > nums[r])
                l = r;
            else 
                --r;
        }
        return nums[l];
    }
}
