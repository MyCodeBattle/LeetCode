/*
 * 和3Sum的方法一样，不赘述。
 */

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int ret, ans;
        for (int i = 0; i < nums.size(); i++) {
            int tar = target - nums[i];
            int l = i + 1, r = nums.size() - 1;
            while (l < r) {
                if (abs(tar - nums[l] - nums[r]) < ans) {
                    ans = abs(tar - nums[l] - nums[r]);
                    ret = nums[i] + nums[l] + nums[r];
                }
                if (nums[l] + nums[r] > tar) {
                    --r;
                }
                else {
                    ++l;
                }
            }
        }
        return ret;
    }
};
