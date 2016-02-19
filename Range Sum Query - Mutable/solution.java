/*
 * 树状数组。
 */

public class NumArray {
    private int[] sum;
    private int[] value;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 10];
        value = new int[nums.length + 10];
        for (int i = 0; i < nums.length; ++i) {
            add(i + 1, nums[i]);
            value[i] = nums[i];
        }
    }

    private int lowbit(int n) {
        return n & (-n);
    }

    private void add(int pos, int val) {
        while (pos < sum.length) {
            sum[pos] += val;
            pos += lowbit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += sum[pos];
            pos -= lowbit(pos);
        }
        return ret;
    }

    void update(int i, int val) {
        add(i + 1, val - value[i]);
        value[i] = val;
    }

    public int sumRange(int i, int j) {
        return query(j + 1) - query(i);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
