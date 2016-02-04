/*
 * 根据后面的余数求即可。
 */

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int mod = n % 26;
            sb.append(mod == 0 ? "Z" : (char) (mod + 'A' - 1));
            n = (n - 1) / 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
