/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode lhs = cur.next, rhs = cur.next.next;
            lhs.next = rhs.next;
            rhs.next = lhs;
            cur.next = rhs;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
