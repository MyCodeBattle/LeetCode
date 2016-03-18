/*
 * 和上题一样，考虑如何去重。
 * 如果当前数字前面出现过而没被使用，当前数字就不能被使用。因为可以用上一个。
 */

class Solution {
public:
    vector<vector<int>> ans;
    vector<int> tmp;
    int target;

    void dfs(int pos, int sum, vector<int> &cur_ans, vector<int> &candidates, bool is_used) {
        if (pos == candidates.size())
        {
            if (sum == target)
                ans.push_back(cur_ans);
            return;
        }
        if (sum > target)
            return;
        if (sum == target) {
            ans.push_back(cur_ans);
            return;
        }
        if (pos + 1 <= candidates.size())
        {
            dfs(pos + 1, sum, cur_ans, candidates, false);
            if (pos && candidates[pos] == candidates[pos - 1] && is_used == false) return;
            cur_ans.push_back(candidates[pos]);
            dfs(pos + 1, sum + candidates[pos], cur_ans, candidates, true);
            cur_ans.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int _target) {
        target = _target;
        if (candidates.empty())
            return ans;
        sort(candidates.begin(), candidates.end());
        dfs(0, 0, tmp, candidates, true);
        return ans;
    }
};


