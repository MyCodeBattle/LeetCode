/*
 * 第一次二分搜索行，第二次搜索列。
 */

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.empty())
            return false;
        int n = matrix.size(), m = matrix[0].size();
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (matrix[mid][0] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        int row = l - 1;
        if (row < 0) 
            return false;
        l = 0, r = m;
        while (l < r) {
            int mid = l + (r - l)/2;
            if (matrix[row][mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l == target;
    }
};
