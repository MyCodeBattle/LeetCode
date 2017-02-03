public class Solution {
    public int myAtoi(String str) {
        int pos = 0;
        int last = 0, ans = 0;
        Integer sign = null;
        while (pos < str.length() && Character.isSpaceChar(str.charAt(pos))) {
            ++pos;
        }
        if (pos == str.length()) {
            return 0;
        }
        if (Character.isAlphabetic(str.charAt(pos)) || pos == str.length()) {
            return 0;
        }
        else if (Character.isDigit(str.charAt(pos)) || str.charAt(pos) == '+') {
            sign = 1;
        }
        else if (str.charAt(pos) == '-') {
            sign = -1;
        }
        if (sign == null) {
            return 0;
        }
        if (!Character.isDigit(str.charAt(pos))) {
            ++pos;
        }
        while (pos < str.length()) {
            if (!Character.isDigit(str.charAt(pos))) {
                return ans;
            }
            if (sign > 0) {
                ans = ans*10 - '0' + (int)str.charAt(pos);
            }
            else {
                ans = ans*10 - (str.charAt(pos) - '0');
            }
            if (ans / 10 != last) {
                return sign > 0 ? 2147483647 : -2147483648;
            }
            last = ans;
            ++pos;
        }
        return ans;
    }
}
