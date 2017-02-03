public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        long l = 0, r = num;
        while (l < r) {
            long mid = l + (r - l)/2;
            if (mid*mid < num) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l*l == num;
    }
}
