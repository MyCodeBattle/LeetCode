/*
 * 状态压缩枚举。
 */

class Solution {
public:
    vector<vector<int>> ans;

    vector<vector<int>> subsets(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        for (int i = 0; i < (1<<n); i++) {
            vector<int> cur_ans;
            for (int j = 0; j < n; j++) if ((1<<j) & i)
                cur_ans.push_back(nums[j]);
            ans.push_back(cur_ans);
        }
        return ans;
    }
};
