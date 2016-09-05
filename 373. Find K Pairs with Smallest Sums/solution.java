public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new ArrayList<int[]>();
        }
        int[] pos = new int[nums2.length];
        Queue<int[]> Q = new PriorityQueue<int[]>((a, b) -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < nums1.length; ++i) {
            Q.offer(new int[]{i, 0});
        }

        List<int[]> ans = new ArrayList<>();
        while (k-- > 0 && !Q.isEmpty()) {
            int[] u = Q.poll();
            ans.add(new int[]{nums1[u[0]], nums2[u[1]]});
            if (++u[1] != nums2.length) {
                Q.offer(new int[]{u[0], u[1]});
            }
        }
        return ans;
    }
}

