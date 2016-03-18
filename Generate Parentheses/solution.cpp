/*
 * dfs一下，我们只要保证左括号的数量 >= 右括号即可，因为这样随便填上一个右括号，必然存在一个匹配的左括号。
 */

class Solution {
public:
    vector<string> ans;
    void dfs(string str, int l, int r) {
        if (!l && !r) {
            ans.push_back(str);
            return;
        }
        if (l) 
            dfs(str+"(", l-1, r);
        if (r > l)
            dfs(str+")", l, r-1);
    }

    vector<string> generateParenthesis(int n) {
        dfs("", n, n);
        return ans;
    }
};
