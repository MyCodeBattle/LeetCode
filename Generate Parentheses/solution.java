public class Solution {
    List<String> ans;

    void dfs(String str, int l, int r) {
        if (l == 0 && r == 0) {
            ans.add(str);
            return;
        }
        if (l != 0)
            dfs(str+"(", l-1, r);
        if (r > l)
            dfs(str+")", l, r-1);
    }

    public List<String> generateParenthesis(int n) {
        this.ans = new ArrayList<>();
        dfs("", n, n);
        return this.ans;
    }
}
