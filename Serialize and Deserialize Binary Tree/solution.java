/*
 * 用先序遍历记录路径。然后恢复一下就行了。
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

import java.util.StringTokenizer;

public class Codec {

    int dfsClock = 0;
    StringBuilder sb = new StringBuilder();
    TreeNode ret = null;

    private void dfs(TreeNode root) {
        if (root == null)
            sb.append("n ");
        else {
            sb.append(root.val + " ");
            dfs(root.left);
            dfs(root.right);
        }
    }

    private void recover(StringTokenizer data, TreeNode root) {
        if (data.hasMoreTokens()) {
            String node = data.nextToken();
            if (node.charAt(0) != 'n') {
                root.left = new TreeNode(Integer.parseInt(node));
                recover(data, root.left);
            }
        }
        if (data.hasMoreTokens()) {
            String node = data.nextToken();
            if (node.charAt(0) != 'n') {
                root.right = new TreeNode(Integer.parseInt(node));
                recover(data, root.right);
            }
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringTokenizer st = new StringTokenizer(data);
        if (!st.hasMoreTokens())
            return null;
        String node = st.nextToken();
        if (node.charAt(0) == 'n')
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));
        recover(st, root);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
