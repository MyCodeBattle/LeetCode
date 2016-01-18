/*
 * 单调栈。从左右两次扫描，维护一下一个数的最大扩展范围，然后乘以高就是它的贡献。
 */

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        if (heights.empty())
            return 0;
        stack<int> stk;
        int left[heights.size()] = {0};
        for (int i = 0; i < heights.size(); i++) {
            while (!stk.empty() && heights[stk.top()] >= heights[i])
                stk.pop();
            left[i] = stk.empty() ? i : i - stk.top() - 1;
            stk.push(i);
        }
        while (!stk.empty())
            stk.pop();
        int ans = 0;
        for (int i = heights.size() - 1; i >= 0; i--) {
            while (!stk.empty() && heights[stk.top()] >= heights[i])
                stk.pop();
            int tmp = stk.empty() ? heights.size() - 1 - i : stk.top() - i - 1;
            ans = max(ans, (tmp + 1 + left[i]) * heights[i]);
            stk.push(i);
        }
        return ans;
    }
};
