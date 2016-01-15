/*
 * 普通dfs。
 */

class Solution {
public:
    int n, k;
    vector<vector<int>> ans;

    void dfs(int cur, int dep, vector<int> &arr) {
        if (dep == k + 1) {
            ans.push_back(arr);
            return;
        }
        for (int i = cur; i <= n; i++) {
            arr.push_back(i);
            dfs(i + 1, dep + 1, arr);
            arr.pop_back();
        }
    }

    vector<vector<int>> combine(int _n, int _k) {
        k = _k; n = _n;
        vector<int> arr;
        dfs(1, 1, arr);
        return ans;
    }
};
