/*
 * 判断进位。
 */

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int len = digits.size();
        int add = 1;
        for (int i = len - 1; i > -1; i--) {
            int sum = digits[i] + add;
            add = sum / 10;
            digits[i] = sum % 10;
        }
        if (add)
            digits.insert(digits.begin(), 1);
        return digits;
    }
};
