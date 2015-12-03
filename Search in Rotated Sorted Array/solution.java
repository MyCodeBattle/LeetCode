public class Solution {
    int ans = 0, target = 0;

    int findPivot(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }

    boolean binarySearch(int l, int r, int[] nums) {
        if (r != 0)
            --r;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] >= target)
                r = mid;
            else
                l = mid + 1;
        }
        this.ans = r;
        return nums[r] == target;
    }

    public int search(int[] nums, int _target) {
        target = _target;
        int idx = findPivot(nums);
        if (binarySearch(idx, nums.length, nums) || binarySearch(0, idx, nums))
            return this.ans;
        return -1;
    }
}
