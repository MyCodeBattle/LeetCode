/*
 * 首先我们可以知道最多只有2个答案。
 * 很神的思路。我们从每个叶子节点，每次都向前走一步，然后消去那个叶子节点。到最后剩下 <= 2个结点的时候就是答案。
 * 类似于Toposort。
 */

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        List<Integer>[] G = new ArrayList[n];
        int[] in = new int[n];
        boolean[] visited = new boolean[n];

        if (n == 0)
            return ans;
        if (n == 1)
            return Arrays.asList(0);
        if (n == 2)
            return Arrays.asList(0, 1);
        for (int i = 0; i < n; ++i)
            G[i] = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();

        for (int[] edge : edges) {
            G[edge[0]].add(edge[1]);
            G[edge[1]].add(edge[0]);
            ++in[edge[1]]; ++in[edge[0]];
        }
        for (int i = 0; i < n; ++i) if (in[i] == 1) {
            Q.offer(i);
            visited[i] = true;
        }

        int cnt = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            cnt += len;
            if (n - cnt <= 2)
                break;
            while (len-- > 0) {
                int u = Q.poll();
                for (int v : G[u]) {
                    --in[v];
                    if (in[v] == 1) {
                        visited[v] = true;
                        Q.offer(v);
                    }
                }
            }
        }
        for (int i = 0; i < n; ++i) if (!visited[i])
            ans.add(i);
        return ans;
    }
}
