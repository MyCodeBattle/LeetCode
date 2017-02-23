public class Solution {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }

        String[] str = {"qwertyuiopQWERTYYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; ++i) {
            for (int j = 0; j < str[i].length(); ++j) {
                map.put(str[i].charAt(j), i);
            }
        }

        for (String word : words) {
            int idx = map.get(word.charAt(0));
            for (int i = 1; i < word.length(); ++i) {
                if (map.get(word.charAt(i)) != idx) {
                    flag = false;
                    break;
                }
            }
            if (flag) {

    }
}
