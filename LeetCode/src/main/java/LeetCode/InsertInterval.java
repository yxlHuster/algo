package LeetCode;

/**
 * Created by allen on 6/6/15.
 */

import common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).
 *
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            } else if (interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval; //save last interval
            } else if (interval.end >= newInterval.start || interval.start <= newInterval.end) { //has intersections
                Interval newInter = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
                newInterval = newInter;
            }
        }
        result.add(newInterval);
        return result;
    }
}
