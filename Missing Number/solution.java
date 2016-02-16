/*
 * 利用累加。
 */

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if (n <= 0)
            return 0;
        int sum = n * (n + 1) / 2;
        int ans = 0;
        for (int num : nums)
            ans += num;
        return sum - ans;
    }
}
