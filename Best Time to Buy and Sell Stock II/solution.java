/*
 * 贪心一下。如果后一天的价格比今天的低，我们就知道今天买明天卖，这样能保证不会亏钱。
 * 如果明天价格比今天低，显然不买。
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int len = prices.length;
        if (len == 0)
            return 0;
        for (int i = 0; i < len - 1; i++) if (prices[i] < prices[i + 1])
            ans += prices[i + 1] - prices[i];
        return ans;
    }
}
