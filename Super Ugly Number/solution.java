/*
 * 每个prime都有自己的指针，指向当前应该乘哪个result。然后我们遍历一遍primes，找出最小的结果。
 * 因为可能会有重复的，所以要再扫描一遍，把相同的结果的指针都加一。
 */

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] indexs = new int[primes.length];
        int[] result = new int[n];
        result[0] = 1;
        if (n == 1)
            return 1;

        for (int i = 0; i < n - 1; ++i) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; ++j)
                ans = Math.min(ans, primes[j] * result[indexs[j]]);
            for (int j = 0; j < primes.length; ++j) if (primes[j] * result[indexs[j]] == ans)
                ++indexs[j];
            result[i + 1] = ans;
        }
        return result[n - 1];
    }
}
