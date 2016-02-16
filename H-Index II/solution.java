/*
 * 这是O((logn)^2)的方法，O(logn)的方法是直接二分。
 * 二分数值，然后lower_bound检验。
 */

public class Solution {

    private int lowerBound(int[] arr, int n) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (arr[mid] < n)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public int hIndex(int[] citations) {
        if (citations.length == 0)
            return 0;

        int l = 0, r = Integer.MAX_VALUE;
        int ans = 0;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (citations.length - lowerBound(citations, mid) >= mid) {
                ans = mid;
                l = mid + 1;
            }
            else 
                r = mid;
        }
        return ans;
    }
}
