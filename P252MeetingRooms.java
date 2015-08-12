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
    public Interval intersect(Interval a, Interval b){
        int start = Math.max(a.start, b.start);
        int end = Math.min(a.end, b.end);
        if(start >= end) return new Interval();
        return new Interval(start, end);
    }
    class IntervalCmp implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start; // increasing order by start time
        }
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        int n = intervals.length;
        if(n<2) return true;
        Arrays.sort(intervals, new IntervalCmp());
        for(int i=1; i<n; i++){
            Interval intersection = intersect(intervals[i-1], intervals[i]);
            if(!(intersection.start == 0 && intersection.end ==0)) return false;
        }
        return true;
    }
}
