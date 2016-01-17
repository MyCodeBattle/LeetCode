/*
 * 这题有点神啊。就是在二分时的两个区域中选择合适的区域查找。
 * 当三个点都是同一个数时这时无法判断，就减少一个单位right。
 */

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < nums[r] || nums[mid] < nums[l]) {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else if (nums[mid] > nums[r] || nums[mid] > nums[l]) {
                if (target < nums[mid] && target >= nums[l])
                    r = mid - 1;
                else  
                    l = mid + 1;
            }
            else
                --r;
        }
        return false;
    }
};

