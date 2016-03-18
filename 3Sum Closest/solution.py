class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        ret = 0
        ans = (1<<31)
        for i in xrange(len(nums)):
            tar = target - nums[i]
            l = i + 1
            r = len(nums) - 1
            while l < r:
                if abs(tar - nums[l] - nums[r]) < ans:
                    ans = abs(tar - nums[l] - nums[r])
                    ret = nums[i] + nums[l] + nums[r]
                if nums[l] + nums[r] > tar:
                    r -= 1
                else:
                    l += 1
        return ret

