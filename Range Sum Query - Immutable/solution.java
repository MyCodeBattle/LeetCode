/*
 * 前缀和。
 */

public class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for (int i = 0; i < nums.length; ++i)
            sum[i] = i == 0 ? nums[i] : nums[i] + sum[i - 1];
    }

    public int sumRange(int i, int j) {
        int l = Math.max(0, i);
        int r = Math.min(sum.length - 1, j);
        return l == 0 ? sum[r] : sum[r] - sum[l - 1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
