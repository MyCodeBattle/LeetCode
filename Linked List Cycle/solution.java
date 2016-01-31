/*
 * Floyd判圈算法。两个指针，一个走一步，一个走两步。
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
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode firstStep = head, secondStep = head;
        while (true) {
            firstStep = firstStep.next;
            secondStep = secondStep.next;
            if (firstStep == null || secondStep == null)
                return false;
            secondStep = secondStep.next;
            if (secondStep == null)
                return false;
            if (secondStep == firstStep)
                return true;
        }
    }
}
