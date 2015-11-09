public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> mp = new HashSet<Character>();
        if (s.isEmpty()) {
            return 0;
        }
        Queue<Character> Q = new LinkedList<Character>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (mp.contains(s.charAt(i))) {
                while (mp.contains(s.charAt(i))) {
                    mp.remove(Q.element());
                    Q.remove();
                }
            }
            Q.add(s.charAt(i));
            mp.add(s.charAt(i));
            ans = Math.max(ans, Q.size());
        }
        return ans;
    }
}
