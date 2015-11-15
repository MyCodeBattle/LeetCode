/*
 * 溢出直接false，负数false，然后得出翻转数就行
 */
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int ret = 0, last = 0;
        while (tmp) {
            ret = ret*10 + tmp%10;
            if (ret / 10 != last) {
                return false;
            }
            tmp /= 10;
            last = ret;
        }
        return ret == x;
    }
};
