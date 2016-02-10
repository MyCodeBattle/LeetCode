/*
 * 这题主要是求出字符串从首字符开始的最长回文串。
 * 这里可以把字符串反一下接起来，用KMP求一下字符串最后的失配位置，这里就是最长的回文串。然后截取剩下的接起来即可。
 */

public class Solution {

    public String shortestPalindrome(String s) {
        if (s.isEmpty())
            return "";

        String sb = s + "#" + new StringBuilder(s).reverse();
        int[] f = new int[sb.length() + 1];
        f[1] = 0;
        for (int i = 1; i < sb.length(); ++i) {
            int pos = f[i];
            while (pos != 0 && sb.charAt(pos) != sb.charAt(i))
                pos = f[pos];
            f[i + 1] = (sb.charAt(pos) == sb.charAt(i) ? pos + 1 : 0);
        }
        return new StringBuilder(s).reverse().substring(0, s.length() - f[sb.length()]) + s;
    }
}

   


