/*
 * 一开始想的是O(n^2logn)的，被卡了。
 * 其实只要枚举i就行了，这样就变成了找两个数的和等于指定k的种类数，two pointers搞搞。复杂度O(n^2)。
 */

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        if (nums.empty()) {
            return ans;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (i && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.size() - 1;
            int sum = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    vector<int> cur = {nums[i], nums[l], nums[r]};
                    ans.push_back(cur);
                    int tmp = nums[l];
                    while (l < r && nums[l] == tmp) {
                        ++l;
                    }
                }
                while (l < r && nums[l] + nums[r] > sum) {
                    --r;
                }
                while (l < r && nums[l] + nums[r] < sum) {
                    ++l;
                }
            }
        }
        return ans;
    }
};

