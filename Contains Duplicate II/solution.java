/*
 * 重新排序然后遍历查找。。
 * 最好的方法是用一个set维护k个位置出现过的数，然后走一步维护一下。
 */

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int[][] pair = new int[nums.length][2];
        for (int i = 0; i < nums.length; ++i) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 1; i < pair.length; ++i) {
            if (pair[i][0] == pair[i - 1][0] && pair[i][1] - pair[i - 1][1] <= k)
                return true;
        }
        return false;
    }
}
