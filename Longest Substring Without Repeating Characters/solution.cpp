//维护一下就行。虽然用STL慢，不过感觉比较优雅

class Solution {
public:
    set<char> mp;
    queue<char> Q;
    int lengthOfLongestSubstring(string s) {
        if (s.empty()) return 0;
        int ans = 0;
        for (int i = 0; i < s.size(); i++)
        {
            while (!Q.empty() && mp.count(s[i]))
            {
                mp.erase(Q.front());
                Q.pop();
            }
            Q.push(s[i]);
            mp.insert(s[i]);
            ans = max(ans, (int)Q.size());
        }
        return ans;
    }
};
