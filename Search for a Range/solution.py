class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        l = 0
        r = len(nums)
        while l < r:
            mid = (l + r) / 2
            if nums[mid] < target:
                l = mid + 1
            else:
                r = mid
        lft = l
        if lft == len(nums) or nums[lft] != target:
            return [-1, -1]
        l = 0
        r = len(nums)
        while l < r:
            mid = (l + r) / 2
            if nums[mid] <= target:
                l = mid + 1
            else:
                r = mid
        return [lft, l - 1]

