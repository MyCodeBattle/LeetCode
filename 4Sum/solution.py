class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        ans = []
        if not nums:
            return ans
        nums.sort()
        for i in xrange(len(nums)):
            if i and nums[i] == nums[i-1]:
                continue
            for j in xrange(i + 1, len(nums)):
                if j - i - 1 and nums[j] == nums[j-1]:
                    continue
                l = j + 1
                r = len(nums) - 1
                tar = target - nums[i] - nums[j]
                while l < r:
                    if nums[l] + nums[r] == tar:
                        ans.append([nums[i], nums[j], nums[l], nums[r]])
                        tmp = nums[l]
                        while l < r and nums[l] == tmp:
                            l += 1
                    while l < r and nums[l] + nums[r] > tar:
                        r -= 1
                    while l < r and nums[l] + nums[r] < tar:
                        l += 1
        return ans
