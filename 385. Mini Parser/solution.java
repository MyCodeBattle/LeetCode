/*
 * 很神奇的思路。思想是记录当前层数，当在一层内并且遇到分隔的时候就递归下去。
 * 和我一开始的想法不一样，我一直去想把当前这一层处理出来然后递归下一层。
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {

    public NestedInteger deserialize(String s) {
        NestedInteger res = new NestedInteger();

        if (s == null || s.isEmpty()) {
            return res;
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        if (s.length() <= 2) {
            return res;
        }

        int start = 1, level = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (level == 0 && (s.charAt(i) == ',' || i == s.length() - 1)) {
                res.add(deserialize(s.substring(start, i)));
                start = i + 1;
            }
            else if (s.charAt(i) == '[') {
                ++level;
            }
            else if (s.charAt(i) == ']') {
                --level;
            }
        }
        return res;
    }
}
