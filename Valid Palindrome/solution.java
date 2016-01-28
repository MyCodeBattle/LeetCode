/*
 * 一次找一对位置。
 */

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isAlphabetic(s.charAt(l)) && !Character.isDigit(s.charAt(l)))
                ++l;
            while (l < r && !Character.isAlphabetic(s.charAt(r)) && !Character.isDigit(s.charAt(r)))
                --r;
            if (Character.toUpperCase(s.charAt(l)) != Character.toUpperCase(s.charAt(r)))
                return false;
            ++l;
            --r;
        }
        return true;
    }
}
