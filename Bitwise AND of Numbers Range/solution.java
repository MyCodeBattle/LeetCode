/*
 * 我们考虑每个二进制位。
 * 如果这期间的某个数这个二进制位是0，这个位就永远是0了。
 * 那么我们可以去从最高位往下，找第一个m是0，n是1的位，我们可以想象，一旦这个位变成1，后面的所有位全是0了。
 */

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int ans = 0;

        for (int i = 30; i >= 0; --i) {
            if (((1 << i) & m) == 0 && ((n >> i) & 1) == 1)
                break;
            else if (((n >> i) & 1) == 1)
                ans |= (1 << i);
        }
        return ans;
    }
}
