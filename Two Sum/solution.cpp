//map / sort

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        vector<pair<int, int> >p;
        for (int i = 0; i < nums.size(); i++) p.push_back({nums[i], i+1});
        if (nums.empty()) return ans;
        sort(p.begin(), p.end());
        int l = 0, r = nums.size()-1;
        while (l != r)
        {
            if (p[l].first + p[r].first == target)
            {
                ans.push_back(p[l].second); ans.push_back(p[r].second);
                if (ans[0] > ans[1]) swap(ans[0], ans[1]);
                return ans;
            }
            else if (p[l].first + p[r].first > target) r--;
            else l++;
        }
    }
};

