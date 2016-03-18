/*
 * atoi
 * 一开始题意弄不清楚
 * 首先，找到第一个符号位
 * 如果后面出现一个非数字符号，就是非法，返回当前数字
 * 处理一下溢出的情况
 */

class Solution {
public:
    string str;

    int find_sign(int &pos) {
        while (pos < str.size() && isspace(str[pos])) {
            ++pos;
        }
        if (isalpha(str[pos]) || pos == str.size()) {
            return 0;
        }
        else if (isdigit(str[pos]) || str[pos] == '+') {
            return 1;
        }
        else if (str[pos] == '-') {
            return -1;
        }
    }

    int myAtoi(string _str) {
        str = _str;
        int pos = 0;
        int last = 0, ans = 0;
        //先找到符号位
        int sign = find_sign(pos);
        if (sign == 0) {
            return 0;    //非法
        }
        if (isalpha(str[pos])) {
            ++pos;
        }
        while (pos < str.size()) {
            if (!isdigit(str[pos])) {
                return ans;
            }
            if (sign > 0) {
                ans = ans*10 - '0' + str[pos];
            }
            else {
                ans = ans*10 - (str[pos] + '0');
            }
            if (ans / 10 != last) return sign > 0 ? 2147483647 : -2147483648;
            last = ans;
            ++pos;
        }
        return ans;
    }
};
