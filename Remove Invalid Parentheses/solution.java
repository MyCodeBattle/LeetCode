/*
 * 这题目在找出合法括号的时候还要求删去的数目尽量小，所以用bfs。
 * 暴力扫描删去每一个括号，然后判断一下。当出现第一个答案之后便不再向队列里添加新元素。
 * 那么问题来了，会不会出现这样一种情况：
 * 比如一个字符串长度为10，我在9的地方删了一个括号，然后出现了一个合法串，然而之前的情况已经入队了，也就是说比ans多一步的情况也在队里，这样会不会把多一步的答案也加进去了。
 * 并不会，因为能形成合法串一定是偶数，多一步就是奇数，不可能。
 */

public class Solution {

    private boolean isValid(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(')
                ++cnt;
            else if (s.charAt(i) == ')') {
                if (cnt-- == 0)
                    return false;
            }
        }
        return cnt == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> Q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> ans = new ArrayList<>();
        visited.add(s);
        Q.offer(s);

        boolean found = false;
        while (!Q.isEmpty()) {
            String str = Q.poll();
            if (isValid(str)) {
                ans.add(str);
                found = true;
                continue;
            }
            if (found)
                continue;

            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')')
                    continue;
                String newString = str.substring(0, i) + str.substring(i + 1);
                if (!visited.contains(newString)) {
                    visited.add(newString);
                    Q.offer(newString);
                }
            }
        }
        return ans;
    }
}
