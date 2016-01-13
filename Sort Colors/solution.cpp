/*
 * 常见的思路是遍历两次。
 * 有种很巧妙的思路，碰到0往左放，2往右放，剩下来的就是1.
 */

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int left = -1, right = nums.size();
        int pos = 0;
        while (pos < right) {
            if (pos == left) 
                ++pos;
            else if (nums[pos] == 0)
                swap(nums[pos], nums[++left]);
            else if (nums[pos] == 2)
                swap(nums[pos], nums[--right]);
            else
                ++pos;
        }
    }
};
