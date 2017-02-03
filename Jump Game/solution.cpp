/*
 * 和之前那个完全一样。
 */

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        if (n == 1)
            return true;
        int max_dis = 0, cur_dis = 0;
        int step = 0;
        while (cur_dis <= max_dis) {
            int next_dis = 0;
            for (int &i = cur_dis; i <= max_dis; i++) {
                next_dis = max(next_dis, nums[i] + i);
                if (next_dis >= n - 1)
                    return true;
            }
            ++step;
            max_dis = next_dis;
        }
        return false;
    }
};

