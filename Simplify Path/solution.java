public class Solution {
    public String simplifyPath(String path) {
        List<String> stk = new ArrayList<>();
        for (String str : path.split("/")) {
            if (str.isEmpty() || str.equals("."))
                continue;
            else if (str.equals("..") && !stk.isEmpty())
                stk.remove(stk.size() - 1);
            else if (!str.equals(".."))
                stk.add(str);
        }
        String ret = "";
        for (String s : stk) ret += "/" + s;
        return ret.isEmpty() ? "/" : ret;
    }
}
