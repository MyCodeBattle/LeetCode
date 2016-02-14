/*
 * 单调队列。
 */

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0)
            return new int[0];
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        int pos = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i >= k) {
                if (deque.peekFirst() <= i - k)
                    deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                    deque.pollLast();
            deque.offerLast(i);
            if (i >= k - 1)
                ans[pos++] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
