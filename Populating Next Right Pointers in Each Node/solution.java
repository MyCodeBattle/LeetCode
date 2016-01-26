/*
 * 这题挺神的，就是用两个指针对应地连起来。
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {

    void dfs(TreeLinkNode l, TreeLinkNode r) {
        l.next = r;
        if (l.left != null) {
            dfs(l.left, l.right);
            dfs(l.right, r.left);
            dfs(r.left, r.right);
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null)
            return;
        dfs(root.left, root.right);
    }
}

