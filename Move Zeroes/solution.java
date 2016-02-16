/*
 * 用一个指针指向可以替换的地方，然后另一个指针遍历一遍，能替换就替换。
 */

public class Solution {
    public void moveZeroes(int[] nums) {
        int placePositon = 0;
        for (int currentPosition = 0; currentPosition < nums.length; ++currentPosition) {
            while (placePositon < currentPosition && nums[placePositon] != 0)
                ++placePositon;
            if (nums[currentPosition] != 0 && currentPosition != placePositon) {
                int temp = nums[placePositon];
                nums[placePositon] = nums[currentPosition];
                nums[currentPosition] = 0;
            }
        }
    }
}
