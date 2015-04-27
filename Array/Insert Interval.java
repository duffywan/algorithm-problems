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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> rst = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            rst.add(newInterval);
            return rst;
        }
        int index = binarySearchInterval(intervals, newInterval);
        intervals.add(index, newInterval);
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
    int binarySearchInterval(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        int j = intervals.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (intervals.get(mid).start == newInterval.start) {
                return mid;
            } else if (intervals.get(mid).start < newInterval.start) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}