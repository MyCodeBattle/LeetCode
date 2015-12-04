/*
 * 就是写STL里的lower_bound和upper_bound，比较的时候加个等号就行了。
 */

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int l = 0, r = nums.size();
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        int lft = l;
        if (lft == nums.size() || nums[lft] != target)
            return {-1, -1};
        l = 0, r = nums.size();
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return {lft, l - 1};
    }
};
