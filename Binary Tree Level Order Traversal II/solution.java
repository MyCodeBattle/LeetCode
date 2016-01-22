/*
 * 不明白这题的意义何在。reverse一下就行了，如果不reverse的话就要用stack存起来，这样就多了O(n)的空间。貌似没有常数空间复杂度又不reverse的方法。
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(ans);
        return ans;
    }
}
