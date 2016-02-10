/*
 * 利用快排进行划分。
 */

import java.util.Random;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k + 1;
        Random random = new Random();
        int start = 0, end = nums.length;
        while (true) {
            int pivot = random.nextInt(end - start);
            int temp = nums[pivot];
            nums[pivot] = nums[end - 1];
            pivot = temp;
            int l = start;
            for (int r = start; r < end - 1; ++r) {
                if (nums[r] <= pivot) {
                    temp = nums[l];
                    nums[l++] = nums[r];
                    nums[r] = temp;
                }
            }
            if (k == l + 1)
                return pivot;
            else if (k < l + 1)
                l = end;
            else
                start = l + 1;
        }
    }
}
