/*
 * 记得要逻辑右移。
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res += (n & 1);
            if (i < 31) 
                res <<= 1;
            n >>>= 1;
        }
        return res;
    }
}
