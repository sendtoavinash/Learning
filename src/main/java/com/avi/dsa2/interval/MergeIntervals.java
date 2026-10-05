package com.avi.dsa2.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Blind 75 - Interval #2: Merge Intervals
 * ------------------------------------------------------------------
 * Problem:
 *   Given a list of intervals, merge all overlapping intervals and return the
 *   non-overlapping result.
 *
 * Example:
 *   [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
 *
 * Approach (sort by start, sweep and extend):
 *   Sort by start time so overlapping intervals sit next to each other. Keep
 *   the "current" merged interval. For each next interval, if its start is <=
 *   the current end they overlap, so stretch the current end to the larger of
 *   the two ends. If it does not overlap, close off the current interval and
 *   start a new one.
 *
 * Complexity:
 *   Time  O(n log n), Space O(n) for output.
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {              // overlaps current
                current[1] = Math.max(current[1], interval[1]);
            } else {                                      // disjoint, start fresh
                current = interval;
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        // [[1, 6], [8, 10], [15, 18]]
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));
        // [[1, 5]]
    }
}
