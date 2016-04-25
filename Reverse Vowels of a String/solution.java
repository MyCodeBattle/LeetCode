/*
 * 用双指针指一下就行。
 */

public class Solution {

    private boolean check(char u) {
        return u != 'a' && u != 'e' && u != 'i' && u != 'o' && u != 'u' && u != 'A' && u != 'E' && u != 'I' && u != 'O' && u != 'U';
    }

    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && check(sb.charAt(l)))
                ++l;
            while (l < r && check(sb.charAt(r)))
                --r;
            char u = sb.charAt(r);
            sb.setCharAt(r, sb.charAt(l));
            sb.setCharAt(l, u);
            ++l;
            --r;
        }
        return sb.toString();
    }
}

