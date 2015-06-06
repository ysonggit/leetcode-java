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
    class IntervalCmp implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }
    public boolean overlap(Interval a, Interval b){
        if(a.end < b.start || a.start > b.end) return false;
        return true;
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals, new IntervalCmp());
        List<Interval> res = new ArrayList<Interval>();
        boolean inserted = false;
        for(Interval cur : intervals){
            if(overlap(newInterval,cur)) {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }else{
                if(!inserted && newInterval.end< cur.start){ // mistake: don't forget check if inserted to avoid insert new interval multiple times
                    inserted = true;
                    res.add(newInterval);
                }
                res.add(cur);
            }
        }
        if(!inserted) res.add(newInterval);
        return res;
    }
}
