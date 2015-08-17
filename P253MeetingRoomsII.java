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
    
    class MinHeapCmp implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.end - b.end; 
        }
    }
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        if(n<2) return n;
        Arrays.sort(intervals, new IntervalCmp());
        PriorityQueue<Interval> minheap = new PriorityQueue<Interval>(n, new MinHeapCmp());
        for(Interval cur : intervals){
            if(minheap.isEmpty()){
                minheap.offer(cur);
            }else{
                // if cur's start time is later than the earliest end time so far (minheap.peek().end)
                // keep on using this room
                if(cur.start >= minheap.peek().end) {
                    Interval earliest_ending_room = minheap.poll(); // must poll the top first then change then insert 
                    earliest_ending_room.end = cur.end;              // after insertion, this may not be the minheap top anymore
                    minheap.offer(earliest_ending_room);
                }
                else minheap.offer(cur);
            }
        }
        return minheap.size();
    }
}
