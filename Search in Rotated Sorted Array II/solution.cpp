class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] < nums[r] || nums[mid] < nums[l]) {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid;
            }
            else if (nums[mid] > nums[r] || nums[mid] > nums[l]) {
                if (target < nums[mid] && target >= nums[l])
                    r = mid;
                else  
                    l = mid + 1;
            }
            else
                --r;
        }
        return nums[l] == target;
    }

