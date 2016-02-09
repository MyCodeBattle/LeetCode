/*
 * 拓扑排序。
 */

public class Solution {
    public int[] findOrder(int numCourses, int[][] p) {
        int[] ans = new int[numCourses];
        int pos = 0;
        List<Integer>[] G = new ArrayList[numCourses];
        int[] in = new int[numCourses];

        for (int i = 0; i < numCourses; ++i)
            G[i] = new ArrayList<>();

        for (int i = 0; i < p.length; ++i) {
            int u = p[i][0], v = p[i][1];
            G[v].add(u);
            ++in[u];
        }

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) if (in[i] == 0) {
            Q.offer(i);
            ans[pos++] = i;
        }
        int cnt = Q.size();
        while (!Q.isEmpty()) {
            int u = Q.remove();
            for (int v : G[u]) {
                --in[v];
                if (in[v] == 0) {
                    Q.offer(v);
                    ans[pos++] = v;
                    ++cnt;
                }
            }
        }
        if (cnt != numCourses)
            return new int[0];
        return ans;
    }
}
