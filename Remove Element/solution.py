class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        if not nums:
            return 0
        pos = 0
        for n in nums:
            if n == val:
                continue
            nums[pos] = n
            pos += 1
        return pos

