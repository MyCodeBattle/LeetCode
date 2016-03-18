class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        mp = dict()
        for i in xrange(len(nums)):
            if target - nums[i] in mp:
                return [mp[target - nums[i]], i + 1]
            else:
                mp[nums[i]] = i + 1
        return []
