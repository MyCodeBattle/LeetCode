/*
 * O(n)算法，挺神奇的。利用了贪心。
 * 维护双指针，显然间隔会越来越少，那么如果a > b，我们就要把b那边的指针移一下。因为移a也没用，瓶颈在b。
 */
class Solution {
public:
    int maxArea(vector<int> &height) {
        int l = 0, r = height.size() - 1;
        int ans = 0;
        while (l < r) {
            ans = max(ans, min(height[r], height[l]) * (r - l));
            if (height[l] > height[r]) {
                r--;
            }
            else {
                l++;
            }
        }
        return ans;
    }
};

/*
 * O(nlogn)算法，从大到小排序，然后维护一下下标的最大值和最小值。
 */
class Solution {
public:
    vector<pair<int, int> > p;
    int maxArea(vector<int>& height) {
        for (int i = 0; i < height.size(); i++) {
            p.push_back({height[i], i+1});
        }
        sort(p.begin(), p.end(), greater<pair<int, int> >());
        int max_len = 0, min_len = ((1ll<<31) - 1);
        int ans = 0;
        for (int i = 0; i < p.size(); i++) {
            if (i) {
                ans = max(ans, p[i].first * max(abs(p[i].second - min_len), abs(p[i].second - max_len)));
            }
            max_len = max(max_len, p[i].second);
            min_len = min(min_len, p[i].second);
        }
        return ans;
    }
};
