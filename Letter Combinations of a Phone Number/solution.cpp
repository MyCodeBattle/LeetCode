/*
 * dfs搞一下就行。
 */

class Solution {
public:
    
    vector<string> ans;
    string digits;

    void dfs(int pos, string cur_ans, string words[]) {
        if (pos == digits.size()) {
            ans.push_back(cur_ans);
            return;
        }
        for (char u : words[digits[pos] - '0']) {
            dfs(pos + 1, cur_ans + u, words);
        }
    }

    vector<string> letterCombinations(string _digits) {
        string words[] = {"f", "f", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        digits = _digits;
        if (digits.empty()) {
            return ans;
        }
        dfs(0, "", words);
        return ans;
    }
};
