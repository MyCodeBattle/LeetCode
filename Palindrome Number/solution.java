public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x, ret = 0, last = 0;
        while (tmp != 0)
        {
            ret = ret*10 + tmp%10;
            tmp /= 10;
            if (ret / 10 != last) {
                return false;
            }
            last = ret;
        }
        return ret == x;
    }
}
