/*
 * 递推过去就行。
 */

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1)
            return ans;
        ans.add(Arrays.asList(1));
        for (int i = 1; i < numRows; ++i) {
            List<Integer> currentLevel = new ArrayList<>();
            currentLevel.add(1);
            for (int j = 1; j <= i; ++j) 
                currentLevel.add(ans.get(ans.size() - 1).get(j - 1) + (j == i ? 0 : ans.get(ans.size() - 1).get(j)));
            ans.add(currentLevel);
        }
        return ans;
    }
}
