package com.avi.dsa2.interval;

import java.util.Arrays;

/**
 * Blind 75 - Interval #3: Non-overlapping Intervals
 * ------------------------------------------------------------------
 * Problem:
 *   Return the minimum number of intervals to remove so the remaining ones do
 *   not overlap.
 *
 * Example:
 *   [[1,2],[2,3],[3,4],[1,3]] -> 1  (remove [1,3])
 *   [[1,2],[1,2],[1,2]]       -> 2
 *
 * Approach (greedy by earliest end time):
 *   This is the classic "activity selection" problem. Sort by END time. Keep as
 *   many intervals as possible: track the end of the last kept interval. If the
 *   next interval starts before that end they overlap, so remove it (count++).
 *   Otherwise keep it and advance the end marker. Choosing the interval that
 *   ends earliest leaves the most room for the rest, which is provably optimal.
 *
 * Complexity:
 *   Time  O(n log n), Space O(1).
 */
public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // sort by end
        int removals = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                removals++;              // overlap -> drop this one
            } else {
                prevEnd = intervals[i][1]; // keep it, advance boundary
            }
        }
        return removals;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}})); // 1
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));         // 2
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));                 // 0
    }
}
