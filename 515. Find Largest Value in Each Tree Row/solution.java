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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> lis = new ArrayList();
        List<Integer> ans = new ArrayList();
        ans.add(root.val);
        lis.add(root);

        int pos = 0;
        while (pos < lis.size()) {
            int limit = lis.size();
            Integer max = null;
            while (pos < limit) {
                TreeNode t = lis.get(pos++);
                if (t.left != null) {
                    if (max == null) {
                        max = t.left.val;
                    }
                    else {
                        max = Math.max(max, t.left.val);
                    }
                    lis.add(t.left);
                }
                if (t.right != null) {
                    if (max == null) {
                        max = t.right.val;
                    }
                    else {
                        max = Math.max(max, t.right.val);
                    }
                    lis.add(t.right);
                }
            }

            if (max != null) {
                ans.add(max);
            }
        }
        return ans;
    }
}
