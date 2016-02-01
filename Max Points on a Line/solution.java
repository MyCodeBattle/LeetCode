/*
 * 我们考虑每个点，和它斜率一样的就是在同一直线上，然后两两扫描一遍，维护一下相同的斜率的个数。
 */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public Point solve(int x, int y) {
        int g = gcd(x, y);
        x /= g;
        y /= g;
        if (y < 0) {
            x = -x;
            y = -y;
        }
        return new Point(x, y);
    }

    public int maxPoints(Point[] points) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        if (points.length == 0)
            return 0;
        int ans = 1;

        for (int i = 0; i < points.length; ++i) {
            map.clear();
            int overlap = 0;
            int tmpAns = 0;

            for (int j = i + 1; j < points.length; ++j) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    ++overlap;
                    continue;
                }
                Point slope = solve(x, y);
                if (!map.containsKey(slope.x)) {
                    Map<Integer, Integer> insideMap = new HashMap<Integer, Integer>();
                    insideMap.put(slope.y, 1);
                    map.put(slope.x, insideMap);
                }
                else {
                    if (map.get(slope.x).containsKey(slope.y))
                        map.get(slope.x).put(slope.y, map.get(slope.x).get(slope.y) + 1);
                    else
                        map.get(slope.x).put(slope.y, 1);
                }
                tmpAns = Math.max(tmpAns, map.get(slope.x).get(slope.y));
            }
            ans = Math.max(ans, tmpAns + overlap + 1);
        }
        return ans;
    }
}
