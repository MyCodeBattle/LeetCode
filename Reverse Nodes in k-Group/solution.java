/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode next_node = null;

    boolean advance(ListNode cur, int k) {
        while (k-- > 0) {
            if (cur == null)
                return false;
            cur = cur.next;
        }
        this.next_node = cur;
        return cur != null;
    }
    
    void solve(ListNode cur_node)
        ListNode l = cur_node.next, r = cur_node.next.next;
        while (true) {
            ListNode tmp = r.next;
            r.next = l;
            l = r;
            r = tmp;
            if (l == this.next_node) {
                cur_node.next.next = tmp;
                cur_node.next = l;
                return;
            }
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1)
            return head;
        ListNode dummy = new ListNode(0), cur_node = dummy;
        dummy.next = head;
        while (advance(cur_node, k)) {
            solve(cur_node);
            advance(cur_node, k);
            cur_node = this.next_node;
        }
        return dummy.next;


}
