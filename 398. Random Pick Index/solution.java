public class Solution {

    private Random r;
    private int[] num;

    public Solution(int[] nums) {
        this.num = nums;
        r = new Random();
    }
    
    public int pick(int target) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < num.length; ++i) {
            int v = num[i];
            if (v == target && r.nextInt(++cnt) == 0) {
                res = i;
            }
        }
        return res;
    }
}
