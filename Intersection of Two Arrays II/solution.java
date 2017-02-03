public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int pos1 = 0, pos2 = 0;
        List<Integer> ans = new ArrayList<>();
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                ans.add(nums1[pos1]);
                ++pos1;
                ++pos2;
            }
            else if (nums1[pos1] < nums2[pos2]) {
                ++pos1;
            }
            else {
                ++pos2;
            }
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i) {
            arr[i] = ans.get(i).intValue();
        }
        return arr;
    }
}
