public class Solution {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] myNums = new int[nums.length * 2];
        for (int i = 0; i < nums.length; ++i) {
            myNums[i] = myNums[i + nums.length] = nums[i];
        }

        int[] ans = new int[nums.length];
        Stack<Integer> stk = new Stack();

        for (int i = 0; i < myNums.length; ++i) {
            if (stk.isEmpty() && i < nums.length) {
                stk.push(i);
            }
            else {
                while (!stk.isEmpty() && nums[stk.peek()] < myNums[i]) {
                    ans[stk.pop()] = myNums[i];
                }
                if (i < nums.length) {
                    stk.push(i);
                }
            }
            
        }
        while (!stk.isEmpty()) {
            ans[stk.pop()] = -1;
        }
        return ans;
    }
}
