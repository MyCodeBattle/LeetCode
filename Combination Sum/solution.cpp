/*
 * 普通的dfs我们普通地做。
 */

class Solution {
public:
    vector<vector<int>> ans;
    vector<int> tmp;
    int target;

    void dfs(int pos, int sum, vector<int> &cur_ans, vector<int> &candidates) {
        if (sum > target)
            return;
        if (sum == target) {
            ans.push_back(cur_ans);
            return;
        }
        for (int i = pos; i < candidates.size(); i++) {
            cur_ans.push_back(candidates[i]);
            dfs(i, sum + candidates[i], cur_ans, candidates);
            cur_ans.pop_back();
        }
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int _target) {
        target = _target;
        if (candidates.empty())
            return ans;
        sort(candidates.begin(), candidates.end());
        candidates.resize(unique(candidates.begin(), candidates.end()) - candidates.begin());
        dfs(0, 0, tmp, candidates);
        return ans;
    }
};
