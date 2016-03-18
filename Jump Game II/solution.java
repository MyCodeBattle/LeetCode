public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) 
            return 0;
        int maxDis = 0, curDis = 0;
        int step = 0;
        while (curDis <= maxDis) {
            int nextDis = 0;
            for (; curDis <= maxDis; curDis++) {
                nextDis = Math.max(nextDis, nums[curDis] + curDis);
                if (nextDis >= n - 1)
                    return step + 1;
            }
            ++step;
            maxDis = nextDis;
        }
        return step;
    }
}
