/*
 * 用了map。
 * 不过这题是sorted array，可以直接减去2个位置来判断是不是同一个数。
 */

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        unordered_map<int, int> mp;
        int pos = 0;
        for (int i = 0; i < nums.size(); i++) {
            ++mp[nums[i]];
            if (mp[nums[i]] <= 2)
                nums[pos++] = nums[i];
        }
        return pos;
    }
};
