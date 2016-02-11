/*
 * 记录一下可能重叠的矩阵坐标，然后判断该矩阵是否存在。
 */

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long leftPoint = Math.max(A, E);
        long rightPoint = Math.min(C, G);
        long upPoint = Math.min(H, D);
        long downPoint = Math.max(B, F);
        long totalArea = (long) (C - A)*(D - B) + (long) (G - E)*(H - F);
        if (rightPoint - leftPoint < 0 || upPoint - downPoint < 0)
            return (int) totalArea;
        long substractArea = Math.max(0, (rightPoint - leftPoint)*(upPoint - downPoint));
        return (int) (totalArea - substractArea);
    }
}
