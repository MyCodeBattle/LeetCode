/*
 * 假设开始到环门口的距离是l1，环门口到相遇的距离是l2，环长度l3。
 * 走得慢的：l1 + l2 + n1*c
 * 走得快的：2(l1 + l2 + n2*c)
 * l1 + l2 + n1*c = 2*l1 + 2*l2 + 2*n2*c
 * l1 = n3*c - l2 = (n3 - 1)*c + (c - l2)
 * 我们现在在l2，c - l2正好是剩下来的那部分，也就是说当一个结点从head走到l1，l2处的点也跟着走，他们相遇时，无论如何l2的那个点都是在入口处。
 * 所以下一次相遇就是l1。
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slowPoint = head, fastPoint = head;
        ListNode entry = head;
        while (fastPoint.next != null && fastPoint.next.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
            if (slowPoint == fastPoint) {
                while (entry != slowPoint) {
                    entry = entry.next;
                    slowPoint = slowPoint.next;
                }
                return entry;
            }
        }
        return null;
    }
}
