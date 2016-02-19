/*
 * 就是暴力枚举前两个字符串，然后判断有没有在之后的字符串中出现。
 * 由于数字太大，要用BigInteger.
 */

import java.math.BigInteger;

public class Solution {
    private boolean dfs(BigInteger first, BigInteger second, String num, int step) {
        if (step <= 2) {
            if (num.charAt(0) == '0')
                return false;
            for (int i = 1; i < num.length(); ++i) {
                if (step == 1) {
                    if (dfs(new BigInteger(num.substring(0, i)), second, num.substring(i), step + 1))
                        return true;
                }
                else if (step == 2) {
                    if (dfs(first, new BigInteger(num.substring(0, i)), num.substring(i), step + 1))
                        return true;
                }
            }
            return false;
        }
        else {
            String target = first.add(second).toString();
            int idx = num.indexOf(target);
            if (idx != 0)
                return false;
            if (target.length() == num.length())
                return true;
            return dfs(second, new BigInteger(num.substring(0, target.length())), num.substring(target.length()), step + 1);
        }
    }

    public boolean isAdditiveNumber(String num) {
        if (num.length() <= 2)
            return false;
        return dfs(BigInteger.ZERO, BigInteger.ZERO, num, 1);
    }
}

