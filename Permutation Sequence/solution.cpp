/*
 * 一个数一个数找，预处理一下阶乘。
 */

class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> arr;
        string ans;
        int fac[10] = {1};
        for (int i = 1; i <= n; i++)
            arr.push_back(i);
        fac[0] = 1;
        for (int i = 1; i <= 9; i++) 
            fac[i] = i * fac[i - 1];
        for (int i = 0; i < n; i++) {
            int num = (k - 1) / fac[n - i - 1];
            k -= num * fac[n - i - 1];
            ans += char(arr[num] + '0');
            arr.erase(arr.begin() + num);
        }
        return ans;
    }
};

