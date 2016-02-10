/*
 * 基本的思想就是把宽度离散了，分成两个点，一个入一个出。
 * 入的点的高度是负的，出的点高度是正的。
 * 然后对X轴排序。
 * 然后用一条扫描线去扫描，如果当前X轴对应的高度是负的，说明又有新高度的建筑进来了，维护一下TreeMap。
 * 如果是正的，说明有建筑出去了，维护一下map。
 * 每次都获取一下map里维护的高度最大值，如果有变化了就加入到答案中。
 * 这里要注意的是一开始对坐标的排序。
 * 当X坐标相同时，我们必须把进入的建筑排在前面，不然会出错。
 */

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0, 1);
        List<int[]> ans = new ArrayList<>();

        int currentHeight = 0;
        for (int[] h : heights) {
            if (h[1] < 0)
                heightMap.put(-h[1], heightMap.containsKey(-h[1]) ? heightMap.get(-h[1]) + 1 : 1);
            else {
                int remainingNum = heightMap.get(h[1]) - 1;
                if (remainingNum == 0)
                    heightMap.remove(h[1]);
                else
                    heightMap.put(h[1], remainingNum);
            }
            if (heightMap.firstKey() != currentHeight) {
                currentHeight = heightMap.firstKey();
                ans.add(new int[]{h[0], currentHeight});
            }
        }
        return ans;
    }
}
