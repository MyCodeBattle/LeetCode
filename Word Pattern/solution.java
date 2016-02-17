/*
 * 用两个map映射一下。
 */

import java.util.StringTokenizer;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        StringTokenizer st = new StringTokenizer(str);
        int pos = 0;
        if (pattern.isEmpty() && str.isEmpty())
            return true;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> rmap = new HashMap<>();

        while (st.hasMoreTokens()) {
            if (pos == pattern.length())
                return false;
            String nextWord = st.nextToken();
            if (map.containsKey(pattern.charAt(pos))) {
                if (!map.get(pattern.charAt(pos)).equals(nextWord)) {
                    return false;
                }
            }
            else if (rmap.containsKey(nextWord)) {
                if (!rmap.get(nextWord).equals(pattern.charAt(pos)))
                    return false;
            }
            else {
                map.put(pattern.charAt(pos), nextWord);
                rmap.put(nextWord, pattern.charAt(pos));
            }
            ++pos;
        }
        return pos == pattern.length();
    }
}
