public class Solution {
    String haystack, needle;

    boolean check(int pos) {
        for (int i = 0; i < this.needle.length(); i++) {
            if (i+pos == this.haystack.length())
                return false;
            if (this.haystack.charAt(i+pos) != this.needle.charAt(i))
                return false;
        }
        return true;
    }
        
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty())
            return 0;
        this.haystack = haystack; this.needle = needle;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length()-i < needle.length())
                return -1;
            if (check(i))
                return i;
        }
        return -1;
    }
}
