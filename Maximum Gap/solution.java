/*
 * 这思路太神了！用桶排序，我们可以确定出一数gap = (max - min) / (n - 1)，这是答案的最小值。然后我们根据这个划分桶，把小于一个gap的都丢到一个桶里，说明在一个桶里的数不可能产生答案。然后我们遍历桶，用上一个桶的最大值和当前桶的最小值维护一下答案即可。
 */

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int minValue = nums[0], maxValue = nums[0];
        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        int gap = (maxValue - minValue + nums.length - 2) / (nums.length - 1);
        int[] minBucket = new int[nums.length];
        int[] maxBucket = new int[nums.length];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == minValue)
                continue;
            int index = (num - minValue) / gap;
            minBucket[index] = Math.min(num, minBucket[index]);
            maxBucket[index] = Math.max(num, maxBucket[index]);
        }

        int ans = 0;
        int previousMax = minValue;
        for (int i = 0; i < nums.length; ++i) {
            if (minBucket[i] == Integer.MAX_VALUE)
                continue;
            ans = Math.max(ans, minBucket[i] - previousMax);
            previousMax = maxBucket[i];
        }
        return ans;
    }
}
