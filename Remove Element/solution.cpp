/*
 * 随便搞搞。
 */

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        if (nums.empty())
            return 0;
        int pos = 0;
        for (int n : nums) {
            if (n == val)
                continue;
            nums[pos++] = n;
        }
        return pos;
    }
};
