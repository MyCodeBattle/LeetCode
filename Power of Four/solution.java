/*
 * 写得很丑。
 */
public class Solution {
    public boolean isPowerOfFour(int num) {

        int cnt = 0;
        for (int i = 0; i < 32; ++i) {
            if ((num & 1) == 1) {
                if (i < 2 || (i & 1) == 1)
                    return false;
                ++cnt;
                if (cnt > 1) 
                    return false;
            }
            num >>= 1;
        }
        return true;
    }
}
