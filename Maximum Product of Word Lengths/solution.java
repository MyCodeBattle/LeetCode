/*
 * O(len)预处理一下每个字符串包含了哪些字符，压位，然后O(n^2)维护最大值。
 * 复杂度max(O(len), O(n^2))。
 */

public class Solution {
    public int maxProduct(String[] words) {
        if (words.length == 0)
            return 0;
        int[] state = new int[words.length];

        for (int j = 0; j < words.length; ++j) {
            for (int i = 0; i < words[j].length(); ++i) 
                state[j] |= (1 << (words[j].charAt(i) - 'a'));
        }

        int ans = 0;
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words.length; ++j) if ((state[i] & state[j]) == 0) {
                ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
