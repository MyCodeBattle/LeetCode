/*
 * two pointers，每次尽量往右扩展，直到 >= sum，然后缩小到 < sum，然后继续扩展。O(n)。
 * O(nlogn)的可以二分长度然后检查。
 */

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;
        int l = 0, r = 0;

        int ans = Integer.MAX_VALUE, currentSum = 0;
        while (r < nums.length) {
            while (r < nums.length && currentSum < s)
                currentSum += nums[r++];
            if (currentSum < s)
                break;
            while (currentSum >= s) 
                currentSum -= nums[l++];
            ans = Math.min(ans, r - l + 1);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

