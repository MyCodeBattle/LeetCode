/*
 * 拓扑排序。
 */

public class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        if (numCourses == 0)
            return true;
        List<Integer>[] G = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; ++i)
            G[i] = new ArrayList<>();
        int[] in = new int[numCourses];

        for (int i = 0; i < p.length; ++i) {
            int u = p[i][0], v = p[i][1];
            G[u].add(v);
            ++in[v];
        }

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) if (in[i] == 0)
            Q.offer(i);
        int cnt = Q.size();
        while (!Q.isEmpty()) {
            int currentCourse = Q.remove();
            for (int v : G[currentCourse]) {
                --in[v];
                if (in[v] == 0) {
                    Q.offer(v);
                    ++cnt;
                }
            }
        }
        return cnt == numCourses;
    }
}
