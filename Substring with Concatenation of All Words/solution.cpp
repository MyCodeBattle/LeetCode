/*
 * 很暴力的方法，O(len * n)，而且还有各种子串。
 * 其实还有更好的办法，类似滑动窗口，懒得写了。
 * Update: Python用这办法TLE了，只能写上。
 */

class Solution {
public:
    vector<int> ans;
    unordered_map<string, int> mp, used;

    vector<int> findSubstring(string s, vector<string>& words) {
        if (words.empty())
            return ans;
        int len = words[0].size();
        for (string &i : words)
            ++mp[i];
        for (int i = 0; i < s.size()-len*words.size()+1; i++) {
            used.clear();
            int cnt = 0;
            for (int j = i; j < s.size(); j += len) {
                string sub = s.substr(j, len);
                if (mp.count(sub)) {
                    ++used[sub]; ++cnt;
                    if (used[sub] > mp[sub])
                        break;
                }
                else break;
                if (cnt == words.size()) {
                    ans.push_back(i);
                    break;
                }
            }
        }
        return ans;
    }
};
