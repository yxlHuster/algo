package LeetCode;

import common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-5-31
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
public class MergeInterval {

    public List<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.isEmpty() || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, getIntervalComparator());
        List<Interval> result = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start > prev.end) {
                result.add(prev);
                prev = current;
            } else {
                Interval merged = new Interval(prev.start, Math.max(prev.end, current.end));
                prev = merged;
            }
        }
        result.add(prev);
        return result;
    }

    public Comparator<Interval> getIntervalComparator() {
        return new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) return Integer.compare(o1.start, o2.start);
                return Integer.compare(o1.end, o2.end);
            }
        };
    }

}
