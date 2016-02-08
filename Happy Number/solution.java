/*
 * 判重。
 */

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();

        while (n != 0) {
            int tmp = n;
            int ans = 0;
            while (tmp != 0) {
                int mod = tmp % 10;
                ans += mod * mod;
                tmp /= 10;
            }
            if (ans == n)
                return true;
            if (map.contains(ans))
                return false;
            map.add(ans);
            n = ans;
        }
        return true;
    }
}
