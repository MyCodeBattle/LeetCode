/*
 * 这一路下来链表都被翻烂了。
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preNode = head, nextNode = head.next;
        head.next = null;
        while (nextNode != null) {
            ListNode tempNextNode = nextNode.next;
            nextNode.next = preNode;
            preNode = nextNode;
            nextNode = tempNextNode;
        }
        return preNode;
    }
}
