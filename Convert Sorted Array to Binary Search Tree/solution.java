/*
 * 左右去递归，这样能保持平衡。
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

    TreeNode dfs(int l, int r, int[] nums) {
        if (l >= r)
            return null;
        int mid = l + (r - l)/2;
        TreeNode currentNode = new TreeNode(nums[mid]);
        currentNode.left = dfs(l, mid, nums);
        currentNode.right = dfs(mid + 1, r, nums);
        return currentNode;
    }
        
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0, nums.length, nums);
    }
}
