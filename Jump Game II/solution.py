class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 1:
            return 0
        max_dis = 0
        cur_dis = 0
        step = 0
        while cur_dis <= max_dis:
            next_dis = 0
            while cur_dis <= max_dis:
                next_dis = max(next_dis, nums[cur_dis] + cur_dis)
                if next_dis >= n - 1:
                    return step + 1
                cur_dis += 1
            step += 1
            max_dis = next_dis
        

