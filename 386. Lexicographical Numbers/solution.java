public class Solution {
    List<Integer> ans = new ArrayList<>();
    int num;

    public List<Integer> lexicalOrder(int n) {
        num = n;
        dfs(0);
        return ans;
    }

    private void dfs(int n) {
        for (int i = 0; i <= 9; ++i) {
            if (i == 0 && n == 0) {
                continue;
            }
            int next = n*10 + i;
            if (next <= num) {
                ans.add(next);
                dfs(next);
            }
        }
    }
}
