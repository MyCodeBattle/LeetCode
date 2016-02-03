/*
 * 模拟之前注意细节。自己的那份写乱了，照着别人的写了一份_(:3」∠)_。
 */

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        Map<Long, Integer> vised = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        sb.append(((numerator < 0) ^ (denominator < 0)) ? "-" :"");
        long num = Math.abs((long) numerator);
        long deno = Math.abs((long) denominator);

        sb.append(num / deno);
        num %= deno;
        if (num == 0)
            return sb.toString();

        sb.append(".");
        vised.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / deno);
            num %= deno;
            if (vised.containsKey(num)) {
                sb.insert(vised.get(num), "(");
                sb.append(")");
                break;
            }
            vised.put(num, sb.length());
        }
        return sb.toString();
    }
}

