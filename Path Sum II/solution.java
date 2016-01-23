/*
 * 和上题一样。
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
    int target = 0;

    void dfs(TreeNode root, int sum, List<Integer> lis) {
        if (root == null)
            return;
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                lis.add(root.val);
                dfs(root.left, sum + root.val, lis);
                lis.remove(lis.size() - 1);
            }
            if (root.right != null) {
                lis.add(root.val);
                dfs(root.right, sum + root.val, lis);
                lis.remove(lis.size() - 1);
            }
        }
        else {
            if (sum + root.val == target) {
                lis.add(root.val);
                ans.add(new ArrayList<Integer>(lis));
                lis.remove(lis.size() - 1);
            }
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return ans;
        target = sum;
        dfs(root, 0, new ArrayList<Integer>());
        return ans;
    }
}
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
    int target = 0;

    void dfs(TreeNode root, int sum, List<Integer> lis) {
        if (root == null)
            return;
        if (root.left != null || root.right != null) {
            if (root.left != null) {
                lis.add(root.val);
                dfs(root.left, sum + root.val, lis);
                lis.remove(lis.size() - 1);
            }
            if (root.right != null) {
                lis.add(root.val);
                dfs(root.right, sum + root.val, lis);
                lis.remove(lis.size() - 1);
            }
        }
        else {
            if (sum + root.val == target) {
                lis.add(root.val);
                ans.add(new ArrayList<Integer>(lis));
                lis.remove(lis.size() - 1);
            }
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return ans;
        target = sum;
        dfs(root, 0, new ArrayList<Integer>());
        return ans;
    }
}
