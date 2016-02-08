/*
 * 不多说了。
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                //tail
                if (cur.next.next == null) {
                    cur.next = null;
                    break;
                }
                else {
                    ListNode nextNode = cur.next.next;
                    cur.next = nextNode;
                    continue;
                }
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
