public class Solution {
    public String convert(String s, int numRows) {
        String ans = "";
        if (numRows == 0) {
            return ans;
        }
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = i, cnt = 0; j < s.length(); ++cnt, j += cnt % 2 != 0 ? (numRows - 1 - i) * 2 : i * 2) {
                if (i == numRows - 1 && cnt % 2 == 0) {
                    ++cnt;
                }
                if (i == 0 && cnt % 2 != 0) {
                    ++cnt;
                }
                ans += s.charAt(j);
            }
        }
        return ans;
    }
}

