/*
 * 有点神奇的思路，就是用两列，分别把小于x的和其他的串起来，最后合成一列。
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
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = new ListNode(0), p2 = new ListNode(0);
        ListNode cur1 = p1, cur2 = p2;
        ListNode pointer = head;
        while (pointer != null) {
            if (pointer.val < x) {
                cur1.next = pointer;
                pointer = pointer.next;
                cur1 = cur1.next;
                cur1.next = null;
            }
            else {
                cur2.next = pointer;
                pointer = pointer.next;
                cur2 = cur2.next;
                cur2.next = null;
            }
        }
        cur1.next = p2.next;
        return p1.next;
    }
}
