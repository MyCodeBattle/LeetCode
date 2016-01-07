/*
 * 二分。也可以写牛顿迭代法。
 */

class Solution {
public:
    int mySqrt(int x) {
        int l = 1, r = 2147483647;
        if (x == 0)
            return 0;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (mid <= x / mid)
                l = mid + 1;
            else
                r = mid;
        }
        return l - 1;
    }
};
