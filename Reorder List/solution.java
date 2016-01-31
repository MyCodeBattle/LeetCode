/*
 * 写的很丑。
 * 主要思路就是把链表截成两半，后一半逆序，然后穿♂插。
 */

public class Solution {
    public int getLength(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            ++cnt;
        }
        return cnt;
    }

    public ListNode getReverseList(ListNode head) {
        ListNode backNode = head.next;
        head.next = null;
        if (backNode == null)
            return head;

        while (backNode != null) {
            ListNode nextNode = backNode.next;
            backNode.next = head;
            head = backNode;
            backNode = nextNode;
        }
        return head;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        int len = getLength(head);
        ListNode halfReverseNode = head;
        for (int cnt = 0; cnt < (len - 1) / 2; ++cnt)
            halfReverseNode = halfReverseNode.next;
        ListNode tmp = halfReverseNode;
        halfReverseNode = halfReverseNode.next;
        tmp.next = null;

        ListNode reverseList = getReverseList(halfReverseNode);

        ListNode ans = new ListNode(0);
        ListNode front = head, back = reverseList;
        while (front != null || back != null) {
            ans.next = front;
            front = front.next;
            ans = ans.next;
            if (back == null)
                break;
            ans.next = back;
            back = back.next;
            ans = ans.next;
        }
    }

}

