/*
 * 从后面开始放。
 */

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos1 = m - 1, pos2 = n - 1;
        while (pos1 >= 0 || pos2 >= 0) {
            if (pos1 >= 0 && pos2 >= 0) {
                if (nums1[pos1] > nums2[pos2])
                    nums1[pos1 + pos2 + 1] = nums1[pos1--];
                else
                    nums1[pos1 + pos2 + 1] = nums2[pos2--];
            }
            else {
                while (pos1 >= 0)
                    nums1[pos1 + pos2 + 1] = nums1[pos1--];
                while (pos2 >= 0)
                    nums1[pos1 + pos2 + 1] = nums2[pos2--];
            }
        }
    }
}
