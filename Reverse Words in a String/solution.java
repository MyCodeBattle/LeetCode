import java.util.StringTokenizer;

public class Solution {
    public String reverseWords(String s) {
        if (s.isEmpty())
            return s;
        StringTokenizer st = new StringTokenizer(s);
        Stack<String> stack = new Stack<>();
        while (st.hasMoreTokens)
            stack.push(st.nextToken());
        String ret = "";
        while (!stack.isEmpty()) {
            ret += (ret.isEmpty() ? "" : " ") + stack.peek();
            stack.pop();
        }
        return ret;
    }
}

