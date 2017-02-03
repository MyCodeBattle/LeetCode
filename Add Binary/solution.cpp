/*
 * 我是先补全0，然后再模拟加。
 */

class Solution {
public:
    string addBinary(string a, string b) {
        string ans;
        if (a.size() < b.size())
            swap(a, b);
        while (b.size() < a.size())
            b.insert(b.begin(), '0');
        int add = 0;
        for (int i = max(a.size(), b.size()) - 1; i > -1; --i) {
            int cur_sum = add;
            add = 0;
            if (i < a.size())
                cur_sum += a[i] - '0';
            if (i < b.size())
                cur_sum += b[i] - '0';
            add = cur_sum / 2;
            ans += char(cur_sum % 2 + '0');
        }
        if (add)
            ans += '1';
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
