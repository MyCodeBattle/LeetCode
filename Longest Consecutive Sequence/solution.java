/*
 * 考虑每个数的贡献。
 * 当填上某个数时，它对左边和右边有影响。
 * 那么我们就可以记录一下它左边序列的长度，和右边序列的长度。
 * 一加，再加上1，就是形成的新序列的长度。
 * 然后我们再更新一下两端就行了。
 */

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int leftLength = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
                int rightLength = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
                int currentSequenceLength = leftLength + rightLength + 1;
                ans = Math.max(ans, currentSequenceLength);
                map.put(nums[i], currentSequenceLength);
                map.put(nums[i] - leftLength, currentSequenceLength);
                map.put(nums[i] + rightLength, currentSequenceLength);
            }
        }
        return ans;
    }
}
