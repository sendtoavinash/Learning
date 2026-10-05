package com.avi.dsa2.interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Blind 75 - Interval #5: Meeting Rooms II
 * ------------------------------------------------------------------
 * Problem:
 *   Given meeting intervals, return the MINIMUM number of conference rooms
 *   required so that no two overlapping meetings share a room.
 *
 * Example:
 *   [[0,30],[5,10],[15,20]] -> 2
 *   [[7,10],[2,4]]          -> 1
 *
 * Approach (sort by start + min-heap of end times):
 *   Sort meetings by start time. Use a min-heap holding the END times of
 *   meetings currently occupying rooms. For each new meeting, if the earliest
 *   ending meeting (heap top) has already finished (end <= new start), that
 *   room frees up, so pop it and reuse. Push the current meeting's end time.
 *   The heap size at any moment is the number of simultaneously busy rooms; its
 *   maximum is the answer.
 *
 * Complexity:
 *   Time  O(n log n), Space O(n).
 */
public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> endTimes = new PriorityQueue<>(); // min-heap of end times
        for (int[] meeting : intervals) {
            if (!endTimes.isEmpty() && endTimes.peek() <= meeting[0]) {
                endTimes.poll(); // a room has freed up, reuse it
            }
            endTimes.offer(meeting[1]);
        }
        return endTimes.size(); // rooms in use at peak
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}})); // 2
        System.out.println(minMeetingRooms(new int[][]{{7, 10}, {2, 4}}));            // 1
    }
}
