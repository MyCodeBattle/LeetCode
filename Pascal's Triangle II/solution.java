/*
 * 推下公式。dp[i + 1] = dp[i] * (n - i) / (i + 1)。
 */

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 0; i < rowIndex; i++) {
            long tmpAns = (long) ans.get(ans.size() - 1) * (rowIndex - i) / (i + 1);
            ans.add((int) tmpAns);
        }
        return ans;
    }
}
