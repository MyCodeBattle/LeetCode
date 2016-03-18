public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList();
        if (nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i - 1 != 0 && nums[j] == nums[j-1]) {
                    continue;
                }
                int l = j + 1, r = nums.length - 1;
                int tar = target - nums[i] - nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] == tar) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        int tmp = nums[l];
                        while (l < r && nums[l] == tmp) {
                            ++l;
                        }
                    }
                    while (l < r && nums[l] + nums[r] > tar) {
                        --r;
                    }
                    while (l < r && nums[l] + nums[r] < tar) {
                        ++l;
                    }
                }
            }
        }
        return ans;
    }
}
