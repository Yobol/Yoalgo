package me.yobol.yoalgo.sort;

import me.yobol.yoalgo.basic.Interval;

import java.util.*;

/**
 * Description:
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
public class MergeIntervals {

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(0, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        for (Interval i : intervals) {
            System.out.print("[" + i.start + ", " + i.end + "]  ");
        }
        System.out.println();
        intervals = mi.merge(intervals);
        for (Interval i : intervals) {
            System.out.print("[" + i.start + ", " + i.end + "]  ");
        }
        System.out.println();
    }
}
