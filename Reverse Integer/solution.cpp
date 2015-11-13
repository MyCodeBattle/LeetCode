/*
 * 这题要考虑的东西还是挺多的，一开始都没考虑到。
 * 是不是负数？反过来溢出了怎么办？前导零？
 * 感觉拿到题目的时候要把思维中默认的东西全部打破掉。
 */
class Solution {
public:
    int reverse(int x) {
        long long ret = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
        }
        while (x) {
            ret = ret*10 + abs(x%10);
            x /= 10;
        }
        if (ret > 2147483647 || ret < -2147483648) {
            return 0;
        }
        return ret * sign;
    }
};
