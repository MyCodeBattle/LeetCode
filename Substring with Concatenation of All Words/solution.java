public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> mp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0)
            return ans;
        int len = words[0].length();
        for (String u : words) {
            Integer v = mp.get(u);
            if (v == null)
                v = 0;
            ++v;
            mp.put(u, v);
        }
        for (int i = 0; i < s.length()-len*words.length+1; i++) {
            HashMap<String, Integer> used = new HashMap<>();
            int cnt = 0;
            for (int j = i; j < s.length() - len + 1 ; j += len) {
                String sub = s.substring(j, j+len);
                if (mp.containsKey(sub)) {
                    Integer v = used.get(sub);
                    if (v == null) 
                        v = 0;
                    ++v;
                    used.put(sub, v);
                    ++cnt;
                    if (v > mp.get(sub))
                        break;
                }
                else
                    break;
                if (cnt == words.length) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}
