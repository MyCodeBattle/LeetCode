public class Solution {
    private List<String> ans = new ArrayList<>();
    private int n;

    public List<String> readBinaryWatch(int num) {
        if (num < 0 || num > 10) {
            return null;
        }
        if (num == 0) {
            return Arrays.asList("0:00");
        }
        this.n = num;
        dfs(-1, 0, 0, 0);
        return ans;
    }

    private void dfs(int pos, int hour, int minute, int cnt) {
        if (cnt == n) {
            if (hour > 11 || minute > 59) {
                return;
            }
            String res = hour + ":";
            res += minute < 10 ? "0" + minute : minute + "";
            ans.add(res);
            return;
        }
        for (int i = pos + 1; i < 10; ++i) {
            int newHour = hour, newMinute = minute;
            if (i < 4) {
                newHour += (1 << i);
            }
            else {
                newMinute += (1 << (i - 4));
            }
            dfs(i, newHour, newMinute, cnt + 1);
        }
    }
}
