public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            int sum = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == sum) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    int tmp = nums[l];
                    while (l < r && nums[l] == tmp) {
                        ++l;
                    }
                }
                while (l < r && nums[l] + nums[r] > sum) {
                    --r;
                }
                while (l < r && nums[l] + nums[r] < sum) {
                    ++l;
                }
            }
        }
        return ans;
    }
}

