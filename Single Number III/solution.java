/*
 * 全部异或一遍，然后就得到ans = x ^ y。
 * 然后随便找一位ans的二进制位为1，重现遍历一遍数组，把所有的数按这位是0还是1分成两组。
 * 这样一来x和y都被分在了不同组，又因为其他的都是成对的，这两组异或之后剩下来的就是两个数。
 */

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xorResult = 0;
        for (int num : nums)
            xorResult ^= num;
        int bit = 0;
        for (bit = 1; ; bit <<= 1) if ((bit & xorResult) != 0)
            break;
        int ans1 = 0, ans2 = 0;

        for (int num : nums) {
            if ((bit & num) != 0)
                ans2 ^= num;
            else
                ans1 ^= num;
        }
        return new int[]{ans1, ans2};
    }
}
