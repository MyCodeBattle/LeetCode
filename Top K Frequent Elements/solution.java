/*
 * O(nlogn) 的偷懒复杂度。
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> {
            Integer x = map.get(a), y = map.get(b);

            if (x > y) {
                return 1;
            }
            if (x == y) {
                return 0;
            }
            return -1;
        });

        int pos = 0;
        while (pos < nums.length) {
            int idx = nums[pos];
            int initialPos = pos;

            while (pos < nums.length && nums[pos] == idx) {
                ++pos;
            }

            map.put(idx, pos - initialPos);
            if (Q.size() < k) {
                Q.offer(idx);
            }
            else {
                if (map.get(Q.peek()) < pos - initialPos) {
                    Q.poll();
                    Q.offer(idx);
                }
            }
        }
        return new ArrayList<Integer>(Q);
    }
}
