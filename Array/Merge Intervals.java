/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rst = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return rst;
        }
        // sort intervals by start time
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        Interval cur = intervals.get(0);
        for (Interval i : intervals) {
            if (i.start <= cur.end) {
                cur.end = Math.max(cur.end, i.end);
            } else {
                rst.add(cur);
                cur = new Interval(i.start, i.end);
            }
        }
        rst.add(cur);
        return rst;
    }
}