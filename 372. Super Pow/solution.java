/**
 * 写得很丑，找循环节。
 */

public class Solution {
    List<Integer> lis = new ArrayList<>();
    Integer entry;

    private int findLoop(long num) {
        Set<Integer> map = new HashSet<>();
        map.add(1);
        lis.add(1);
        int len = 1;
        long ori = 1;
        while (true) {
            int rem = (int) (ori*num % 1337);
            if (map.contains(rem)) {
                entry = lis.indexOf(rem);
                return len;
            }
            ++len;
            ori = ori*num % 1337;
            lis.add(rem);
            map.add(rem);
        }
    }

    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
       

        int loopLength = findLoop(a);
        System.out.println(loopLength);
        loopLength = loopLength - entry;
        StringBuilder sb = new StringBuilder();
        for (int v : b) {
            sb.append(v);
        }
        String str = sb.toString();
        int rem = 0;
        for (int i = 0; i < str.length(); ++i) {
            int u = str.charAt(i) - '0';
            rem = (rem*10 + u) % loopLength;
        }
        return lis.get(entry + rem - ((entry % loopLength) + loopLength) % loopLength);
    }
}

