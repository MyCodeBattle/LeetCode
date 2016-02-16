/*
 * 用了优先队列，有点不优雅，O(nlogn)。
 */

public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1)
            return 1;
        Queue<Long> Q = new PriorityQueue<>();
        Q.offer(2L); Q.offer(3L); Q.offer(5L);

        int cnt = 1;
        Set<Long> vised = new HashSet<>();
        while (true) {
            long u = Q.poll();
            if (vised.contains(u))
                continue;
            vised.add(u);
            ++cnt;
            if (cnt == n)
                return (int) u;
            Q.offer(u*2); Q.offer(u*3); Q.offer(u*5);
        }
    }
}
