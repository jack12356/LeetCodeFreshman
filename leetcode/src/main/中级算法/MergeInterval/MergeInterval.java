package MergeInterval;


import Interval.Interval;

import java.util.*;

public class MergeInterval {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.end-i2.end;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        if (len==0) return intervals;
        intervals.sort(new IntervalComparator());
        for (int i = len-1; i >0 ; i--) {
            Interval cur = intervals.get(i);
            Interval pre = intervals.get(i-1);
            if (cur.start<=pre.end){
                if(pre.start<=cur.start){
                    pre.end = cur.end;
                    intervals.remove(i);
                }else intervals.remove(i-1);
            }
        }
        return intervals;
    }
}
