public class Solution {
    public int reverse(int x) {
        long ret = 0;
        int sign = 1;
        if (x < 0) {
            sign = -1;
        }
        while (x != 0) {
            ret = ret*10 + Math.abs(x%10);
            x /= 10;
        }
        if (ret > 2147483647 || ret < -2147483648) {
            return 0;
        }
        return (int)ret * sign;
    }
}
