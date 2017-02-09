public class Solution {
    public int findPoisonedDuration(int[] t, int d) {
        if (t == null || t.length == 0) {
            return 0;
        }

        int pos = t[0] - 1, ans = 0;
        for (int v : t) {
            if (v > pos) {
                pos = v + d - 1;
                ans += d;
            }
            else {
                if (v + d - 1 > pos) {
                    ans += v + d - 1 - pos;
                    pos = v + d - 1;
                }
            }
        }

        return ans;
    }
}
