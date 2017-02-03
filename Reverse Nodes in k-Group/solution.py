# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):

    def advance(self, cur, k):
        while k:
            k -= 1
            if k < 0:
                break
            if not cur:
                return False
            cur = cur.next
        self.next_node = cur
        return cur != None
    
    def solve(self, cur_node):
        l, r = cur_node.next, cur_node.next.next
        while True:
            tmp = r.next
            r.next = l
            l = r
            r = tmp
            if l == self.next_node:
                cur_node.next.next = tmp
                cur_node.next = l
                return

    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if k <= 1:
            return head
        dummy = ListNode(0)
        cur_node = dummy
        dummy.next = head
        self.next_node = None
        while self.advance(cur_node, k):
            self.solve(cur_node)
            self.advance(cur_node, k)
            cur_node = self.next_node
        return dummy.next


