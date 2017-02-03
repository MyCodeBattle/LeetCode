public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            ans = Math.max(Math.min(height[l], height[r]) * (r - l), ans);
            if (height[l] > height[r]) {
                r--;
            }
            else {
                l++;
            }
        }
        return ans;
    }
}
