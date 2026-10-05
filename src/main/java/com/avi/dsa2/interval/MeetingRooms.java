package com.avi.dsa2.interval;

import java.util.Arrays;

/**
 * Blind 75 - Interval #4: Meeting Rooms
 * ------------------------------------------------------------------
 * Problem:
 *   Given meeting time intervals [start, end], determine whether a person can
 *   attend ALL meetings (i.e. no two meetings overlap).
 *
 * Example:
 *   [[0,30],[5,10],[15,20]] -> false (0-30 overlaps 5-10)
 *   [[7,10],[2,4]]          -> true
 *
 * Approach (sort by start, scan adjacent):
 *   Sort meetings by start time. If any meeting begins before the previous one
 *   ends, they overlap and the answer is false. One linear scan after sorting
 *   is enough because overlaps can only occur between time-adjacent meetings.
 *
 * Complexity:
 *   Time  O(n log n) for the sort, Space O(1).
 */
public class MeetingRooms {

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // starts before the previous one ends
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}})); // false
        System.out.println(canAttendMeetings(new int[][]{{7, 10}, {2, 4}}));            // true
    }
}
