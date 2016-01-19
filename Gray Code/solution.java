/*
 * 我这种方法是暴力了，每次加入没访问过的状态。
 * 另一种比较快的方法是考虑每位的贡献，在当前已到达的状态上都加上某一位。
 */

public class Solution {
    public List<Integer> grayCode(int n) {
        HashSet<Integer> vis = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int curState = 0;
        vis.add(0); ans.add(0);
        for (int i = 1; i < (1<<n); i++) {
            for (int j = 0; j < n; j++) if (!vis.contains(curState ^ (1<<j))) {
                curState ^= (1<<j);
                vis.add(curState);
                ans.add(curState);
                break;
            }
        }
        return ans;
    }
}
