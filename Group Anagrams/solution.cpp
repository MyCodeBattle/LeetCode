/*
 * 本来想随便写个暴力试试的，没想到竟然过了。。
 * 用一个pair，第一关键词存排序后的每个单词，第二关键词存本来的单词，sort一下就行。
 */

class Solution {
public:
    vector<vector<string>> ans;
    vector<pair<string, string>> arr;
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        if (strs.empty())
            return ans;
        for (int i = 0; i < strs.size(); i++) {
            string s = strs[i];
            sort(strs[i].begin(), strs[i].end());
            arr.push_back({strs[i], s});
        }
        sort(arr.begin(), arr.end());
        vector<string> cur_ans;
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0 || arr[i].first == arr[i-1].first) 
                cur_ans.push_back(arr[i].second);
            else {
                ans.push_back(cur_ans);
                cur_ans.clear();
                cur_ans.push_back(arr[i].second);
            }
        }
        ans.push_back(cur_ans);
        return ans;
    }
};
