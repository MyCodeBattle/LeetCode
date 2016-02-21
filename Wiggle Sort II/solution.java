/*
 * 我们可以得知，大的位置的数的个数是len - len/2。
 * 那么我们把数组排个序，用两个指针一个指向大的一个指向小的，按顺序放就行。
 * 至于为什么是从后面往前面放，这样能最大程度减少相等的数相邻放置的情况。
 * 考虑一下这个数据就知道了:4 5 5 6。
 * 如果我们从前往后放，那么两个5的间距只有1，显然重复了。
 * 从后往前放，他们间隔了2个位置。5 6 4 5
 * 上面的是马后炮，是我从前往后放了一次WA了才知道的。
 */

public class Solution {
    public void wiggleSort(int[] nums) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);
        int big = nums.length - 1;
        int small = nums.length - nums.length/2 - 1;

        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copyNums[small--];
            if (i != nums.length - 1)
                nums[i + 1] = copyNums[big--];
        }

    }
}
