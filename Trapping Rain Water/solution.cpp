/*
 * 这思路太神了！！！
 * two pointers，倒跟前面有一题挺像的，两个point比一下，符合某种情况的自增/自减。
 * 对于这题，我们考虑两个point的数，对于其中小一点的那个数，我们可以想象中他的左边倒水，这里的水一定有max_left - height[i]的贡献，因为它一定可以至少被右边的墙堵住。
 * 太神了！
 */

class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int max_left = 0, max_right = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                max_left = max(max_left, height[left]);
                ans += max_left - height[left++];
            }
            else {
                max_right = max(max_right, height[right]);
                ans += max_right - height[right--];
            }
        }
        return ans;
    }
};
