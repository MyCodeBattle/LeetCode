/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> Q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        ListNode head = new ListNode(0), cur = head;
        for (ListNode curNode : lists) if (curNode != null)
            Q.add(curNode);
        while (!Q.isEmpty()) {
            cur.next = Q.poll();
            cur = cur.next;
            if (cur.next != null)
                Q.add(cur.next);
        }
        return head.next;
    }
}
