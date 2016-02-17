/*
 * 这么看。
 * 前三个先手必胜。第四个的时候先手不管怎么转移都输，第五个先手可以转移到4的状态。以此类推。
 * 1 2 3 4 5 6 7 8
 * w w w l w w w l
 */

public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
