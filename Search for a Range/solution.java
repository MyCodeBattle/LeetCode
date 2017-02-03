public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        int lft = l;
        if (lft == nums.length || nums[lft] != target)
            return new int[]{-1, -1};
        l = 0; r = nums.length;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return new int[]{lft, l - 1};
    }
}
