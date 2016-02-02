/*
 * 每一段的乘积和等于总的乘积和除以之前的连续乘积和，也就是前缀和的思想。
 * 那么我们维护一下负数的最大值就行了，根据当前乘积和选择如何更新。
 */

public class Solution {
    public int maxProduct(int[] nums) {
        long negativeMinValue = Long.MIN_VALUE;
        long product = 1;
        long ans = Long.MIN_VALUE;
        for (int num : nums) {
            product *= num;
            if (product > 0 || negativeMinValue == Long.MIN_VALUE)
                ans = Math.max(ans, product);
            else
                ans = Math.max(ans, product / negativeMinValue);
            if (product < 0)
                negativeMinValue = Math.max(negativeMinValue, product);
            else if (product == 0) {
                product = 1;
                negativeMinValue = Long.MIN_VALUE;
            }
        }
        return (int) ans;
    }
}
