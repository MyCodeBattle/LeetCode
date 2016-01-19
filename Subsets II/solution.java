/*
 * 为了避免重复出现元素，我们可以将相同的元素分组，然后以固定数量向之前的状态中添加，这样就避免了一个状态添加了两种一样的分组。
 */

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            int count = 0;
            while (count + i < nums.length && nums[i + count] == nums[i])
                ++count;
            int sz = ans.size();
            for (int j = 0; j < sz; j++) {
                List<Integer> ins = new ArrayList<>(ans.get(j));
                for (int k = 0; k < count; k++) {
                    ins.add(nums[i]);
                    ans.add(new ArrayList<Integer>(ins));
                }
            }
            i += count;
        }
        return ans;
    }
}
