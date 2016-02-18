/*
 * O(nlogn)，如果比最后一个数大就加入arr，否则找到第一个比它大的替换掉。
 */

public class Solution {

    private int lowerBound(List<Integer> arr, int n) {
        int l = 0, r = arr.size();
        while (l < r) {
            int mid = l + (r - l)/2;
            if (arr.get(mid) < n)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();

        for (int num : nums) {
            if (arr.isEmpty() || num > arr.get(arr.size() - 1))
                arr.add(num);
            else {
                int pos = lowerBound(arr, num);
                arr.set(pos, num);
            }
        }
        return arr.size();
    }
}
