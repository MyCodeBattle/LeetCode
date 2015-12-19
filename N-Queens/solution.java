public class Solution {
    List<List<String>> ans = new ArrayList<>();
    int n;

    void dfs(int curRow, int v1, int v2, int v3, List<String> mp) {
        if (curRow == n) {
            ans.add(new ArrayList<>(mp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((v1 & (1 << i)) != 0 || (v2 & (1 << (curRow + i))) != 0 || (v3 & (1 << (curRow - i + n - 1))) != 0)
                continue;
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[i] = 'Q';
            mp.add(new String(arr));
            dfs(curRow + 1, v1 | (1 << i), v2 | (1 << (curRow + i)), v3 | (1 << (curRow - i + n - 1)), mp);
            mp.remove(mp.size() - 1);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        List<String> mp = new ArrayList<>();
        dfs(0, 0, 0, 0, mp);
        return ans;
    }
}
