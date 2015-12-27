public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        String ans = "";
        int[] fac = new int[10];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr.add(i);
            fac[i] = i * fac[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int num = (k - 1) / fac[n - i - 1];
            k -= num * fac[n - i - 1];
            ans += (char)(arr.get(num) + (int)('0'));
            arr.remove(num);
        }
        return ans;
    }
}
