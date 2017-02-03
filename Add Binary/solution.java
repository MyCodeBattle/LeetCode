public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder aa = new StringBuilder(a), bb = new StringBuilder(b);
        StringBuilder ret = new StringBuilder();
        while (aa.length() < bb.length())
            aa.insert(0, '0');
        while (bb.length() < aa.length())
            bb.insert(0, '0');
        int add = 0;
        for (int i = aa.length() - 1; i > -1; i--) {
            int curSum = add + Integer.parseInt(String.valueOf(aa.charAt(i))) + Integer.parseInt(String.valueOf(bb.charAt(i)));
            add = curSum / 2;
            ret.append(curSum % 2);
        }
        if (add != 0)
            ret.append(1);
        return ret.reverse().toString();
    }
}
