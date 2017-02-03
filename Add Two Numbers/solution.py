# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        add = 0
        head = ListNode(0)
        last = head
        while not(not l1 and not l2 and not add):
            sum = (l1.val if l1 else 0) + (l2.val if l2 else 0) + add
            add = sum / 10
            new_node = ListNode(sum % 10)
            last.next = new_node
            last = new_node
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        return head.next

