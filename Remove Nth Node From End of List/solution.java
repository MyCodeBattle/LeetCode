/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode head = null;

    ListNode remove(ListNode cur, int curPos, int tarPos) {
        if (curPos + 1 == tarPos) {
            cur.next = cur.next.next;
        }
        else {
            remove(cur.next, curPos + 1, tarPos);
        }
        return cur;
    }

    int getLen(ListNode cur) {
        if (cur == null) {
            return 0;
        }
        return 1 + getLen(cur.next);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        this.head = head;
        int len = getLen(head);
        int pos = len - n;
        if (pos == 0) {
            return head.next;
        }
        return remove(head, 0, pos);
    }
}
