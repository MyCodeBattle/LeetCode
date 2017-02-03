/*
 * 对于当前的数，可以选也可以不选。不选的话就转移前一个数的最大值，选的话考虑接下去选还是另起一段。
 */

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int dp[n][2] = {0};
        if (nums.empty())
            return 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = -2147483648;
                dp[i][1] = nums[i];
            }
            else {
                dp[i][0] = max(dp[i-1][0], dp[i-1][1]);
                dp[i][1] = max(dp[i-1][1] + nums[i], nums[i]);
            }
        }
        return max(dp[n-1][0], dp[n-1][1]);
    }
};
