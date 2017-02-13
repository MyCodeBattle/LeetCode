class Node {
    public Integer profit = 0;
    public Integer capital = 0;

    Node(Integer p, Integer c) {
        profit = p;
        capital = c;
    }

}

public class Solution {
    public int findMaximizedCapital(int k, int W, int[] p, int[] c) {
        if (p == null || c == null) {
            return 0;
        }

        PriorityQueue<Node> Q = new PriorityQueue<>((a, b) -> {
            if (a.profit != b.profit) {
                return b.profit - a.profit;
            }
            return a.capital - b.capital;
        });

        List<Node> lis = new ArrayList<>();
        for (int i = 0; i < p.length; ++i) {
            lis.add(new Node(p[i], c[i]));
        }

        lis.sort((a, b) -> a.capital - b.capital);

        int pos = 0;
        while (k-- > 0) {
            while (pos < lis.size() && lis.get(pos).capital <= W) {
                Q.offer(lis.get(pos++));
            }

            if (Q.isEmpty()) {
                break;
            }
            W += Q.peek().profit;
            Q.poll();
        }
        return W;

    }
}
