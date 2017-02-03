/*
 * 无聊的模拟。
 */

class Solution {
public:
    std::vector<string> fullJustify(std::vector<string>& words, int maxWidth) {
        std::vector<string> ans;
        int st = -1, ed = 0, cur_len = 0;
        while (ed < words.size() ) {
            if (ed != words.size() && cur_len + ed - st - 1 + words[ed].size() <= maxWidth) {
                cur_len += words[ed].size();
                ++ed;
            }
            else {
                std::string str;
                int spaces = maxWidth - cur_len;
                int tmp_pos = st + 1;
                str += words[tmp_pos++];
                if (ed - st - 1 == 1) {   //只有一个单词
                    str.append(spaces, ' ');
                    st = ed - 1;
                    ans.push_back(str);
                    cur_len = 0;
                    continue;
                }
                int remainder = spaces % (ed - st - 2), add = spaces / (ed - st - 2);
                cout << str << endl;
                for (; tmp_pos < ed; ++tmp_pos) {
                    if (remainder) {
                        str += ' ';
                        --remainder;
                    }
                    str.append(add, ' ');
                    str += words[tmp_pos];
                }
                ans.push_back(str);
                st = ed - 1;
                cur_len = 0;
            }
        }
        string str = words[st + 1];
        for (int i = st + 2; i < words.size(); ++i)
            str = str + ' ' + words[i];
        str.append(maxWidth - str.size(), ' ');
        ans.push_back(str);
        return ans;
    }
};
