/*
 * 我们用dp[i]表示i的1的个数。
 * 我们观察一下就能得知，8~15，就是1 + dp[0~7]。
 * 所以每次这么推下来就行了。
 * 判断需要重新置pos了的条件就是2*pos + 1 == i。
*/

public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int pos = 0;

        dp[0] = 0; 
        for (int i = 1; i <= num; ++i) {
            dp[i] = dp[pos] + 1;
            if (2*pos + 1 == i)
                pos = 0;
            else
                ++pos;
        }
        return dp;
    }
}
