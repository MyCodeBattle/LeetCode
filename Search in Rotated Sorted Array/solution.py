class Solution(object):
    def find_pivot(self, nums):
        l = 0 
        r = len(nums) - 1
        while l < r:
            mid = l + (r - l)/2
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid
        return r

    def binary_search(self, l, r, nums):
        if r:
            r -= 1
        while l < r:
            mid = l + (r - l)/2
            if nums[mid] >= self.target:
                r = mid
            else:
                l = mid + 1
        self.ans = r
        return nums[r] == self.target

    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        self.target = target
        idx = self.find_pivot(nums)
        if self.binary_search(idx, len(nums), nums) or self.binary_search(0, idx, nums):
            return self.ans
        return -1


