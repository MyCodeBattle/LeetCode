/*
 * 用两个指针l、r，一前一后。假设pos是第一个翻转结点的前一个结点，整个过程就是pos->next = r, r->next = l，l++, r++，最后改一下第一个翻转结点的next，这样就串成一串了。
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        if (n <= 1)
            return head;
        dummy.next = head;
        ListNode l = dummy, r = dummy;
        for (int i = 1; i < m; i++) {
            l = l.next;
            r = r.next;
        }
        ListNode pos = l;
        l = l.next;
        ListNode lastNode = l;
        r = r.next.next;
        for (int i = 0; i < n - m; i++) {
            ListNode nextStep = r.next;
            pos.next = r;
            System.out.println(pos.next.val);
            r.next = l;
            l = r;
            r = nextStep;
        }
        lastNode.next = r;
        return dummy.next;
    }
}
