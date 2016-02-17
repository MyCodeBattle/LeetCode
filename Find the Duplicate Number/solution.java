/*
 * 二分数，然后遍历数组，如果小于mid的数 <= mid，说明答案在右边，否则根据鸽巢原理，答案在左边。O(nlogn)。
 * O(n)的方法是模仿Floyd判圈算法，用两个变量一直置换，然后根据之前推的公式找到环的入口。
 * 太神了！
 */

public class Solution {
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l)/2;
            int smaller = 0;
            for (int num : nums) {
                if (num <= mid)
                    ++smaller;
            }
            if (smaller > mid)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
