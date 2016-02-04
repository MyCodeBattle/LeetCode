/*
 * Moore's Voting Algorithm.
 */

public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 1, currentNum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != currentNum)
                --cnt;
            else
                ++cnt;
            if (cnt < 0) {
                cnt = 0;
                currentNum = nums[i];
            }
        }
        return currentNum;
    }
}
