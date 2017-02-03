public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int pos = 0;
        for (int n : nums) {
            if (n == nums[pos])
                continue;
            nums[++pos] = n;
        }
        return pos + 1;
    }
}
