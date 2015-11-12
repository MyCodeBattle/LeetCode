/*
 * 显然每一行每个数字在字符串中的位数是有规律的。我们可以发现，对于每一行，他的下一个数是先往下找，然后往上找。依次循环。
 * 那么我们就可以根据这个来推出下个数出现的位置。
 * 如果是往下找的话，显然要(numRows-1-i)*2次，反之则i*2次。
 */

class Solution {
public:
    string convert(string s, int numRows) {
        string ans;
        if (numRows == 0) {
            return ans;
        }
        if (numRows == 1) {
            return s;
        }
        for (int i = 0, cnt = 1; i < numRows; i++, cnt++) {
            for (int j = i; j < s.size(); j += (cnt & 1) ? (numRows - 1 - i) * 2 : i * 2) {
                ans += s[i];
            }
        }
        return ans;
    }
};
