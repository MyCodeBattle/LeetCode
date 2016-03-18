/*
 * 首先我们二分找出pivot，然后在pivot两边二分。
 */

class Solution {
public:
    int ans, target;

    int find_pivot(vector<int> &nums) {
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }

    bool bs(int l, int r, vector<int> &nums) {
        if (r != 0)
            --r;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] >= target)
                r = mid;
            else 
                l = mid + 1;
        }
        this->ans = r;
        return nums[r] == target;
    }

    int search(vector<int>& nums, int _target) {
        target = _target;
        int idx = find_pivot(nums);
        if (bs(idx, nums.size(), nums) || bs(0, idx, nums))
            return this->ans;
        return -1;
    }
};
