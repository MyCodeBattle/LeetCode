/*
 * 递归到链表尾部，然后回溯的时候用一个指针往前走，比一下。
 * 空间复杂度O(1)。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution { 
    ListNode currentNode = null;

    private boolean dfs(ListNode head) {
        if (head.next != null) {
            if (!dfs(head.next))
                return false;
        }
        if (head.val != currentNode.val)
            return false;
        currentNode = currentNode.next;
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        currentNode = head;
        return dfs(head);
    }
}
