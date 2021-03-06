/*
 * 过。
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.next.val < cur.val) {
                ListNode pre = dummy;
                while (pre.next != null && pre.next.val < cur.next.val)
                    pre = pre.next;
                ListNode tmpNode = pre.next;
                pre.next = cur.next;
                cur.next = cur.next.next;
                pre.next.next = tmpNode;
            }
            else
                cur = cur.next;
        }
        return dummy.next;
    }
}
