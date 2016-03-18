public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int target = 0, len = 0;

    void dfs(int pos, int sum, ArrayList<Integer> cur_ans, int[] candidates) {
        if (sum > target)
            return;
        if (sum == target) {
            ans.add(new ArrayList<Integer>(cur_ans));
            return;
        }
        for (int i = pos; i < len; i++) {
            cur_ans.add(candidates[i]);
            dfs(i, sum + candidates[i], cur_ans, candidates);
            cur_ans.remove(cur_ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        if (candidates.length == 0)
            return ans;
        Arrays.sort(candidates);
        this.len = unique(candidates);
        dfs(0, 0, new ArrayList<Integer>(), candidates);
        System.out.println(ans.toString());
        return ans;
    }

    int unique(int[] arr) {
        int pos = 0, read = 0;
        while (true) {
            arr[pos] = arr[read];
            while (read < arr.length && arr[read] == arr[pos])
                ++read;
            ++pos;
            if (read == arr.length)
                break;
        }
        return pos;
    }
}
