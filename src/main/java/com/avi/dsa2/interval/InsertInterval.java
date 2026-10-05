package com.avi.dsa2.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Blind 75 - Interval #1: Insert Interval
 * ------------------------------------------------------------------
 * Problem:
 *   Given a list of NON-overlapping intervals sorted by start, insert a new
 *   interval and merge if necessary so the result stays sorted and
 *   non-overlapping.
 *
 * Example:
 *   intervals=[[1,3],[6,9]], newInterval=[2,5] -> [[1,5],[6,9]]
 *
 * Approach (three phases in one pass):
 *   Because the input is already sorted we handle it in three stages:
 *     1. Add every interval that ends BEFORE newInterval starts (no overlap,
 *        strictly to the left).
 *     2. Merge every interval that overlaps newInterval by expanding
 *        newInterval's bounds, then add it once.
 *     3. Add every remaining interval that starts AFTER newInterval ends.
 *
 * Complexity:
 *   Time  O(n), Space O(n).
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1. intervals entirely before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        // 2. merge all overlapping intervals into newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        // 3. intervals entirely after newInterval
        while (i < n) {
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        // [[1, 5], [6, 9]]
        System.out.println(Arrays.deepToString(
                insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        // [[1, 2], [3, 10], [12, 16]]
    }
}
