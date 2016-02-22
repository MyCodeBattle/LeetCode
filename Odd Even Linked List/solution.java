/*
 * 用两个指针串一下。
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
    public ListNode oddEvenList(ListNode head) {

        if (head == null)
            return null;

        ListNode cur = head;
        ListNode odd = new ListNode(0), even = new ListNode(0);
        ListNode evenBegin = even;
        int cnt = 0;
        while (cur != null) {
            cnt ^= 1;
            if (cnt == 1) {
                odd.next = cur;
                odd = odd.next;
            }
            else {
                even.next = cur;
                even = even.next;
            }
            cur = cur.next;
        }
        odd.next = evenBegin.next;
        even.next = null;
        return head;
    }
}
