/*
 * 考虑当前位1的贡献，分成三种情况。
 * 如果等于1，他的贡献就是(这一位之前的数 + 1) * 权值 + 这一位之后的数。
 * 其他的两种情况以此类推。
 */

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        long weigh = 1;
        int ans = 0;

        while (n/weigh != 0) {
            long beforeNumber = n/(weigh*10);
            long afterNumber = n % weigh;
            long currentNumber =  n/weigh % 10;

            if (currentNumber == 1)
                ans += beforeNumber*weigh + afterNumber + 1;
            else if (currentNumber > 1)
                ans += (beforeNumber + 1) * weigh;
            else
                ans += beforeNumber * weigh;
            weigh *= 10;
        }
        return ans;
    }
}
