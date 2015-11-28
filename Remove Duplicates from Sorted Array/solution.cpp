/*
 * 随便搞搞。
 */

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty())
            return 0;
        int pos = 0;
        for (int i : nums) {
            if (i == nums[pos])
                continue;
            nums[++pos] = i;
        }
        return pos + 1;
    }
};
