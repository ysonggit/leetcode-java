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
        if(a.end>= b.start) return true;
        return false;
    }
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        if(n<2) return intervals;
        Collections.sort(intervals, new IntervalCmp());
        List<Interval> res = new ArrayList<Interval>();
        res.add(intervals.get(0));
        for(int i=1; i<n; i++){
            Interval cur = intervals.get(i);
            if(!overlap(res.get(res.size()-1), cur)){
                res.add(cur);
            }else{
                res.get(res.size()-1).end = Math.max(cur.end, res.get(res.size()-1).end);
            }
        }
        return res;
    }
}
