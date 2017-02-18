public class Solution {
    public String convertToBase7(int num) {
        StringBuffer sb = new StringBuffer();
        boolean isNeg = (num < 0);

        if (isNeg) {
            num = -num;
        }
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }

        if (isNeg) {
            sb.append("-");
        }

        if (sb.length() == 0) {
            sb.append("0");
        }

        sb.reverse();
        return sb.toString();

    }
}
