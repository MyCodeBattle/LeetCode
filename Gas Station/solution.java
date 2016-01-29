/*
 * 有两个很重要的结论。
 * 1. 如果车只能从A开到B，那么它们之间的任意一点都不可能开到B + 1.
 * 2. 如果车开完全程油还有，说明存在某一点，使得一路上不会出现负数。
 *
 * 第一个很显然，车能从A开到B，说明路途上一直有油。那么去掉一些站点肯定不会使结果变好。
 * 第二个结论还想不出什么数学的证明方法_(:3」∠)_
 */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainingGas = 0;
        int start = 0;
        int totalGas = 0;

        for (int i = 0; i < gas.length; ++i) {
            remainingGas += gas[i] - cost[i];
            if (remainingGas < 0) {
                start = i + 1;
                remainingGas = 0;
            }
            totalGas += gas[i] - cost[i];
        }
        return totalGas < 0 ? -1 : start;
    }
}
