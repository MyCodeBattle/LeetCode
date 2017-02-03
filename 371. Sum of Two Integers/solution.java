/*
 * 位运算判断
 */
public class Solution {
    public int getSum(int a, int b) {
        int add = 0;
        int ans = 0;

        for (int i = 0; i < 32; ++i) {
            if (((a >> i) & 1) == 1) {
                ++add;
            }
            if (((b >> i) & 1) == 1) {
                ++add;
            }
            if (add >= 2) {
                add -= 2;
                ans |= (add << i);
                add = 1;
            }
            else {
                ans |= (add << i);
                add = 0;
            }
        }
        return ans;
    }
}
