# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def remove(self, head):
        if not head:
            return 0, head
        i, head.next = self.remove(head.next)
        return i + 1, (head, head.next)[i + 1 == self.n]

    def removeNthFromEnd(self, head, n):
        self.head = head
        self.n = n
        return self.remove(head)[1]

