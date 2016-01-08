/*
 * 用/作为分割，判断能不能退即可。
 */

class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stk;
        string str;
        stringstream ss(path);
        while (getline(ss, str, '/')) {
            if (str.empty() || str == ".")
                continue;
            else if (str == ".." && !stk.empty())
                stk.pop_back();
            else if (str != "..") 
                stk.push_back(str);
        }
        string ret;
        for (string s : stk) ret += "/" + s;
        return ret.empty() ? "/" : ret;
    }
};
