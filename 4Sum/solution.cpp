/*
 * 和之前的3Sum一样，就多了一个循环。O(n^3)。
 */

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> ans;
        if (nums.empty()) {
            return ans;
        }
        sort(nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
            if (i && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < nums.size(); j++) {
                if (j - i - 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int l = j + 1, r = nums.size() - 1;
                int tar = target - nums[i] - nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] == tar) {
                        ans.push_back({nums[i], nums[j], nums[l], nums[r]});
                        int tmp = nums[l];
                        while (l < r && nums[l] == tmp) {
                            ++l;
                        }
                    }
                    while (l < r && nums[l] + nums[r] > tar) {
                        --r;
                    }
                    while (l < r && nums[l] + nums[r] < tar) {
                        ++l;
                    }
                }
            }
        }
        return ans;
    }
};
