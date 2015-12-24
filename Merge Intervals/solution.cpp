/*
 * 维护一下当前区间的l和最长延伸的r即可。
 */

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:

    vector<Interval> ans;
    static int cmp(const Interval a, const Interval b) {
        if (a.start != b.start)
            return a.start < b.start;
        return a.end < b.end;
    }

    vector<Interval> merge(vector<Interval>& intervals) {
        if (intervals.empty())
            return ans;
        sort(intervals.begin(), intervals.end(), cmp);
        bool first = true;
        int l, r;
        for (Interval u : intervals) {
            if (first) {
                first = false;
                l = u.start; r = u.end;
            }
            else if (u.start > r) {
                ans.push_back(Interval(l, r));
                l = u.start; r = u.end;
            }
            else
                r = max(r, u.end);
        }
        ans.push_back(Interval(l, r));
        return ans;
    }
};
