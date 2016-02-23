/*
 * 我们用两个变量维护前面的两个数。
 * first < second。
 * 如果当前数 > second，成立。
 * 如果当前数 > first，second取最小值。
 * 如果当前数 < first，我们用当前数去替换first，因为这么做并不会使结果发生改变，而且能使之后得到更优的结果。
 */

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > second)
                return true;
            else if (num > first)
                second = Math.min(second, num);
            else
                first = num;
        }
        return false;
    }
}
            
