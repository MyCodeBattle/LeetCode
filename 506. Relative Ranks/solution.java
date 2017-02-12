public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null) {
            return new String[0];
        }

        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            lis.add(i);
        }

        lis.sort((a, b) -> nums[b] - nums[a]);
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                ans[lis.get(i)] = "Gold Medal";
            }
            else if (i == 1) {
                ans[lis.get(i)] = "Silver Medal";
            }
            else if (i == 2) {
                ans[lis.get(i)] = "Bronze Medal";
            }
            else {
                ans[lis.get(i)] = i + 1 + "";
            }
        }
        return ans;
    }
}
