/*
 * 用一个queue把一层都push了，然后add一下就行。
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

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return ans;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int levelNum = Q.size();
            List<Integer> lis = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (Q.peek().left != null)
                    Q.offer(Q.peek().left);
                if (Q.peek().right != null)
                    Q.offer(Q.peek().right);
                lis.add(Q.poll().val);
            }
            ans.add(lis);
        }
        return ans;
    }
}
