# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        cur = dummy
        while cur.next and cur.next.next:
            lhs = cur.next
            rhs = cur.next.next
            lhs.next = rhs.next
            rhs.next = lhs
            cur.next = rhs
            cur = cur.next.next
        return dummy.next

