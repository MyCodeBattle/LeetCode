/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    private List<Interval> ans;
    private Set<Integer> mp;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        ans = new LinkedList<>();
        mp = new HashSet<>();
    }
    
    public void addNum(int val) {
        Integer leftMost = Integer.MIN_VALUE, rightMost = Integer.MAX_VALUE;
        if (mp.contains(val)) 
            return;

        mp.add(val);

        Interval temp = new Interval(val, val);
        if (leftMost != null || rightMost != null) {
            ListIterator<Interval> it = ans.listIterator();
            while (it.hasNext()) {
                Interval u = it.next();
                if (u.end == val - 1) {
                    temp.start = u.start;
                    it.remove();
                }
                if (u.start == val + 1) {
                    temp.end = u.end;
                    it.remove();
                }
            }
        }
        ans.add(temp);
        ans.sort((a, b) -> {
            if (a.start < b.start)
                return -1;
            return 1;
        });

    }
    
    public List<Interval> getIntervals() {
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */

