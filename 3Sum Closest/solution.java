public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = 0, ans = (int)((1l<<31) - 1);
        for (int i = 0; i < nums.length; i++) {
            int tar = target - nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (Math.abs(tar - nums[l] - nums[r]) < ans) {
                    ans = Math.abs(tar - nums[l] - nums[r]);
                    ret = nums[i] + nums[l] + nums[r];
                }
                if (nums[l] + nums[r] > tar) {
                    --r;
                }
                else {
                    ++l;
                }
            }
        }
        return ret;
    }
}
