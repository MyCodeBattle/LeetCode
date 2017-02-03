public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> mp = new HashSet<>();

        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        for (int num : nums1) {
            mp.add(num);
        }
        return Arrays.stream(nums2).filter(e -> mp.contains(e)).distinct().toArray();
    }
}
