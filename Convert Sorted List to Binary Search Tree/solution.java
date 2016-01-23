/*
 * 和之前的一样，只不过找中点的时候要遍历一下。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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

    TreeNode dfs(int start, int end, ListNode startNode) {
        if (start >= end)
            return null;
        int mid = start + (end - start)/2;
        ListNode tmpListNode = startNode;
        //System.out.println(tmpListNode.val);
        for (int i = 0; i < mid - start; ++i)
            tmpListNode = tmpListNode.next;
        TreeNode currentTreeNode = new TreeNode(tmpListNode.val);
        currentTreeNode.left = dfs(start, mid, startNode);
        currentTreeNode.right = dfs(mid + 1, end, tmpListNode.next);
        return currentTreeNode;
    }

    int getLength(ListNode curNode) {
        int len = 0;
        while (curNode != null) {
            curNode = curNode.next;
            ++len;
        }
        return len;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        int len = getLength(head);
        return dfs(0, len, head);
    }
}

