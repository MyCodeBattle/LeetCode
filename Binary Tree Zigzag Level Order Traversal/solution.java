/* 
 * 两个栈或者两个队列都可以，标记一下这轮是先加左儿子还是有儿子。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        boolean reverse = false;
        Stack<TreeNode> stk1 = new Stack<>(), stk2 = new Stack<>();
        stk1.push(root);
        while (!stk1.isEmpty() || !stk2.isEmpty()) {
            int levelLength = reverse ? stk2.size() : stk1.size();
            List<Integer> lis = new ArrayList<>();
            for (int i = 0; i < levelLength; ++i) {
                if (reverse) {
                    if (stk2.peek().right != null)
                        stk1.push(stk2.peek().right);
                    if (stk2.peek().left != null)
                        stk1.push(stk2.peek().left);
                }
                else {
                    if (stk1.peek().left != null)
                        stk2.push(stk1.peek().left);
                    if (stk1.peek().right != null)
                        stk2.push(stk1.peek().right);
                }
                lis.add(reverse ? stk2.pop().val : stk1.pop().val);
            }
            reverse = !reverse;
            ans.add(lis);
        }
        return ans;
    }
}
