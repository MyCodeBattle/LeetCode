class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        pos = 0
        for n in nums:
            if n == nums[pos]:
                continue
            pos += 1
            nums[pos] = n
        return pos + 1
