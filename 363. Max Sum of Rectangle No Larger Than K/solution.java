public class Solution {
    private int k;

    private int lowerBound(int l, int r, int tar, int[] arr) {
        while (l < r) {
            int mid = l + (r-l)/2;
            if (arr[mid] <= tar) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }

    private int getAns(int[] res) {
        int ans = 0;
        for (int i = 0; i < res.length; ++i) {
            int target = k - res[i];
            if (res[i] <= k) {
                ans = Math.max(ans, res[i]);
            }

            int idx = lowerBound(0, i, target, res);
            ans = Math.max(ans, res[i] - res[idx]);
        }
        return ans;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int[] res = new int[m];
                for (int k = 0; k < m; ++k) {
                    res[k] = (i == 0 ? sum[j][k] - sum[i - 1][k] : sum[j][k]);
                }

                ans = Math.max(ans, getAns(res));
            }
        }

        return ans;
    }
}
