public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        int res = 0;
        long sum = 0;
        treeMap.put(0L, 1);
        for (int v : nums) {
            sum += v;
            Map<Long, Integer> subMap = treeMap.subMap(sum - upper, true, sum - lower, true);
            for (int num : subMap.values()) {
                res += num;
            }
            treeMap.putIfAbsent(sum, 0);
            treeMap.put(sum, treeMap.get(sum) + 1);
        }
        return res;
    }
}

