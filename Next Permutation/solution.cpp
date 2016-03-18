/*
 * 今天的是参考了题解，还没完全理解。
 */

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int k = -1;
        for (int i = nums.size() - 2; i >= 0; i--) if (nums[i] < nums[i + 1]) {
            k = i;
            break;
        }
        if (k == -1) {
            reverse(nums.begin(), nums.end());
            return;
        }
        int l = -1;
        for (int i = nums.size() - 1; i >= 0; i--) if (nums[i] > nums[k]) {
            l = i;
            break;
        }
        swap(nums[k], nums[l]);
        reverse(nums.begin() + k + 1, nums.end());
    }
};
