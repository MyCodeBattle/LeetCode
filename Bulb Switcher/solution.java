/*
 * 首先我们知道，如果一个数的约数个数是偶数，那么它是关的，否则开。
 * 因为约数是成对的，所以一般的数的约数都是偶数，除非他是平方数。
 * 所以就变成了n之内有几个平方数。
 */

public class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
