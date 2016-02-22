/*
 * 我们统计一下当前剩余的坑数即可。
 * 一个结点可以提供两个坑，自己又占去一个坑，所以一个结点相当于提供一个坑。
 * 一个#占一个坑。
 * 遍历一遍，看是不是都是合法的。
 */

public class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.isEmpty())
            return false;
        String[] nodes = preorder.split(",");

        int cnt = 1;
        for (String node : nodes) {
            if (node.charAt(0) == '#') {
                if (--cnt < 0)
                    return false;
            }
            else {
                if (cnt == 0)
                    return false;
                ++cnt;
            }
        }
        return cnt == 0;
    }
}
