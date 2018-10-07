package me.yobol.yoalgo.sort;

import me.yobol.yoalgo.basic.Interval;

import java.util.ArrayList;
import java.util.List;

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

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) return null;
        if (intervals.size() <= 1) return intervals;

        List<Interval> result = new ArrayList<>();
        Interval current, prior = null;

        // 一次将原Interval列表中的元素取出
        while (!intervals.isEmpty()) {
            current = intervals.remove(0);

            if (prior != null) {
                if (prior.end >= current.start) {
                    Interval temp = new Interval(prior.start, current.end);
                    result.add(temp);
                    prior = temp;
                } else {
                    result.add(current);
                }
            } else {
                prior = current;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
//        intervals.add(new Interval(2, 6));
//        intervals.add(new Interval(8, 10));
//        intervals.add(new Interval(15, 18));
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
