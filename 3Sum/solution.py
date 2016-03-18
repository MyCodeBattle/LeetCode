class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ans = []
        if len(nums) == 0:
            return ans
        nums.sort()
        for i in xrange(len(nums)):
            if i and nums[i] == nums[i-1]:
                continue
            l = i + 1
            r = len(nums) - 1
            sum = -nums[i]
            while l < r:
                if nums[l] + nums[r] == sum:
                    ans.append([nums[i], nums[l], nums[r]])
                    tmp = nums[l]
                    while l < r and nums[l] == tmp:
                        l += 1
                while l < r and nums[l] + nums[r] > sum:
                    r -= 1
                while l < r and nums[l] + nums[r] < sum:
                    l += 1
        return ans

