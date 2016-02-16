/*
 * O(nlong)可以排序或者二分，介绍一下O(n)的方法。
 * 树状数组的思想。
 * cnt[i]表示数i的个数。
 * 当一个数大于length时，我们不必统计他的个数了，因为这个数肯定不会是答案，只需把答案累加到length上。
 * 然后我们从后往前累加，每次加上cnt[i]，这样累加器sum的值就是 >= i 的数量，直到我们找到第一个答案。
 */

public class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;

        int[] cnt = new int[citations.length + 1];
        for (int num : citations) {
            if (num >= citations.length)
                ++cnt[citations.length];
            else
                ++cnt[num];
        }

        int sum = 0;
        for (int i = citations.length; i >= 0; --i) {
            sum += cnt[i];
            if (sum >= i)
                return i;
        }
        return 0;
    }
}
