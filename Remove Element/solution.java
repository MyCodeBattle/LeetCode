public class Solution {
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        if (nums.length == 0)
            return 0;
        for (int n : nums) {
            if (n == val)
                continue;
            nums[pos++] = n;
        }
        return pos;
    }
}
