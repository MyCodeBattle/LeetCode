/*
 * 先统计一下t里面各种字符的个数，然后用两个指针在s里找。
 * 当l指针的个数超过原本的个数时，我们接下来的串都是非法的，所以我们就一直推进l指针，直到再次和原本的个数相等。然后推进r指针，以此类推。
 */

class Solution {
public:
    string minWindow(string s, string t) {
        int cnt[200] = {0}, cur[200] = {0};
        if (s.empty())
            return "";
        int all_num = 0, cur_num = 0;
        for (char i : t) {
            cnt[i]++;
            if (cnt[i] == 1)
                ++all_num;
        }
        int l = 0, r = 0, len = 0x3f3f3f3f;
        string ans;
        while (r < s.size()) {
            ++cur[s[r]];
            if (cur[s[r]] == cnt[s[r]]) {
                ++cur_num;
            }
            while (cur[s[l]] > cnt[s[l]]) {
                --cur[s[l]];
                ++l;
            }
            if (cur_num == all_num && r - l + 1 < len) {
                ans = s.substr(l, r - l + 1);
                len = r - l + 1;
            }
            ++r;
        }
        return ans;
    }
};
