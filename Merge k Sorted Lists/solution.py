# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from heapq import *
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        ret = ListNode(3)
        head = ret
        Q = [(i.val, i) for i in lists if i]
        heapify(Q)
        while Q:
            v, n = Q[0]
            heappop(Q)
            ret.next = n
            if n.next:
                heappush(Q, (n.next.val, n.next))
            ret = ret.next
        return head.next

            
