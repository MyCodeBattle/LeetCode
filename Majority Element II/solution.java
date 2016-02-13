public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<Integer>();

        int firstElement = 0, firstCount = 0;
        int secondElement = 1, secondCount = 0;
        for (int num : nums) {
            if (num == firstElement)
                ++firstCount;
            else if (num == secondElement)
                ++secondCount;
            else if (firstCount == 0) {
                firstCount = 1;
                firstElement = num;
            }
            else if (secondCount == 0) {
                secondCount = 1;
                secondElement = num;
            }
            else {
                --firstCount;
                --secondCount;
            }
        }

        firstCount = 0;
        secondCount = 0;
        for (int num : nums) {
            if (num == firstElement)
                ++firstCount;
            else if (num == secondElement)
                ++secondCount;
        }

        List<Integer> ans = new ArrayList<>();
        if (firstCount > nums.length / 3)
            ans.add(firstElement);
        if (secondCount > nums.length / 3)
            ans.add(secondElement);
        return ans;
    }
}
