/*
 * 先拿到两个链的长度，走到同一起点上，然后先后走一步判断即可。O(1)空间。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            ++cnt;
            head = head.next;
        }
        return cnt;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        if (len1 > len2)
            for (int i = 0; i < len1 - len2; ++i)
                headA = headA.next;
        else
            for (int i = 0; i < len2 - len1; ++i)
                headB = headB.next;
        if (headA == headB)
            return headA;

        while (headB != null) {
            headA = headA.next;
            headB = headB.next;
            if (headA == headB)
                return headA;
        }
        return null;
    }
}
