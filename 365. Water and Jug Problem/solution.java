public class Solution {

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        return z % gcd(x, y) == 0 ? "True" : "False";
    }
}
