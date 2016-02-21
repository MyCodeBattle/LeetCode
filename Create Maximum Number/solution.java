/*
 * 先考虑一个简易版问题：从一个数组里按顺序取出k个数，求组成的最大的数。
 * 这里可以用一个栈维护，当当前数num大于栈顶并且pop出栈顶后还能组成k长度的数，那么就可以pop。
 * 然后考虑两个数组，其实就是第一个数组取0个，第二个数组取k个; 第一个数组取1个，第二个数组取k - 1个，这k种情况。
 * 我们计算k种情况，维护一下最大值。
 *
 * 当合并两个数组时，如果arr1[i] > arr2[j]，显然选择放置arr1[i]。
 * 那如果arr1[i] = arr2[j]呢？
 * 我们就要看后面的数，如果后面的数arr1 > arr2，就要选择arr1[i]。
 * 如果一直相同，我们就要一直比下去。
 * 时间复杂度O((n + m)^3)
 */

public class Solution {
    private int[] getMaxArray(int[] arr, int len) {
        if (len == 0)
            return new int[0];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            while (!stack.isEmpty() && stack.peek() < arr[i] && stack.size() + arr.length - i > len)
                stack.pop();
            if (stack.size() < len)
                stack.push(arr[i]);
        }
        int[] ret = new int[len];
        int pos = len - 1;
        while (!stack.isEmpty())
            ret[pos--] = stack.pop();
        return ret;
    }

    private boolean isGreater(int[] arr1, int pos1, int[] arr2, int pos2) {
        while (pos1 < arr1.length && pos2 < arr2.length && arr1[pos1] == arr2[pos2]) {
            ++pos1;
            ++pos2;
        }
        return pos2 == arr2.length || (pos1 != arr1.length && arr1[pos1] > arr2[pos2]);
    }

    private int[] merge(int[] arr1, int[] arr2, int k) {
        int[] ret = new int[k];
        int pos = 0, pos1 = 0, pos2 = 0;
        while (pos < k)
            ret[pos++] = isGreater(arr1, pos1, arr2, pos2) ? arr1[pos1++] : arr2[pos2++];
        return ret;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[k];

        for (int i = Math.max(0, k - len2); i <= k && i <= len1; ++i) {
            int[] res = merge(getMaxArray(nums1, i), getMaxArray(nums2, k - i), k);
            if (isGreater(res, 0, ans, 0))
                ans = res;
        }
        return ans;
    }

}
