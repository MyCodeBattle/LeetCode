/*
 * 滑动窗口。
 */

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        if (s.length() < 10)
            return ans;
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            if (i == 9)
                map.put(sb.toString(), 0);
            if (i >= 10) {
                sb.deleteCharAt(0);
                String currentString = sb.toString();
                if (map.containsKey(currentString)) {
                    if (map.get(currentString) == 0) {
                        ans.add(currentString);
                        map.put(currentString, 1);
                    }
                }
                else
                    map.put(currentString, 0);
            }
        }
        return ans;
    }
}
