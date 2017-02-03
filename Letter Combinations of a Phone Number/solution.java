public class Solution {

    String digits;
    List<String> ans;
    String[] words = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    void dfs(int pos, String cur_ans) {
        if (pos == digits.length()) {
            ans.add(cur_ans);
            return;
        }
        for (int i = 0; i < words[digits.charAt(pos) - '0'].length(); i++) {
            dfs(pos + 1, cur_ans + words[digits.charAt(pos) - '0'].charAt(i));
        }
    }

    public List<String> letterCombinations(String _digits) {
        digits = _digits;
        ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        dfs(0, "");
        return ans;
    }
}
