/*
 * 因为跳的每一段都是连续的，如果能以x步到达a点，那么a点之前的点都可以在x步之前到达，那么我们就可以枚举每一步来计算最大达到的距离。
 */

class Solution {
public:
    int *step;
    int jump(vector<int>& nums) {
        int n = nums.size();
        if (n == 1)
            return 0;
        int max_dis = 0, cur_dis = 0;
        int step = 0;
        while (cur_dis <= max_dis) {
            int next_dis = 0;
            for (int &i = cur_dis; i <= max_dis; i++) {
                next_dis = max(next_dis, nums[i] + i);
                if (next_dis >= n - 1)
                    return step + 1;
            }
            ++step;
            max_dis = next_dis;
        }
    }
};
