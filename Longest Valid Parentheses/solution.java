public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (stk.empty())
                stk.push(i);
            else {
                if (s.charAt(i) == ')' && s.charAt(stk.peek()) == '(') {
                    stk.pop();
                    ans = Math.max(ans, i - (stk.empty() ? -1 : stk.peek()));
                }
                else 
                    stk.push(i);
            }
        }
        if (stk.empty())
            ans = s.length();
        return ans;
    }
}
        
