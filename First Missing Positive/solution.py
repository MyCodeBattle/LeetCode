class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for i in xrange(len(nums)):
            while nums[i] > 0 and nums[i] <= len(nums) and nums[nums[i] - 1] != nums[i]:
                u, v = nums[i], nums[nums[i] - 1]
                nums[nums[i] - 1] = u
                nums[i] = v
        for i in xrange(len(nums)):
            if nums[i] != i + 1:
                return i + 1
        return len(nums) + 1

a = Solution()
print a.firstMissingPositive([2, 1])

