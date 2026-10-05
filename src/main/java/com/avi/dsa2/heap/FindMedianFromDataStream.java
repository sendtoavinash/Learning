package com.avi.dsa2.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Blind 75 - Heap #1: Find Median from Data Stream
 * ------------------------------------------------------------------
 * Problem:
 *   Design a structure that supports addNum(num) to ingest a stream of integers
 *   and findMedian() to return the median of all numbers seen so far.
 *
 * Example:
 *   addNum(1); addNum(2); findMedian() -> 1.5; addNum(3); findMedian() -> 2.0
 *
 * Approach (two heaps balancing around the middle):
 *   Keep the smaller half of the numbers in a MAX-heap (lo) and the larger half
 *   in a MIN-heap (hi). The two tops straddle the median. On each insert, push
 *   into lo, move lo's largest into hi (keeps order correct), then rebalance so
 *   lo has either the same count as hi or exactly one more. The median is then:
 *     - lo's top, if lo holds one extra element (odd total), or
 *     - the average of both tops (even total).
 *
 * Complexity:
 *   Time  O(log n) per addNum, O(1) per findMedian, Space O(n).
 */
public class FindMedianFromDataStream {

    private final PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
    private final PriorityQueue<Integer> hi = new PriorityQueue<>();                            // min-heap

    public void addNum(int num) {
        lo.offer(num);          // add to the lower half
        hi.offer(lo.poll());    // push lo's max over to hi to keep ordering
        if (hi.size() > lo.size()) {
            lo.offer(hi.poll()); // rebalance so lo >= hi in size
        }
    }

    public double findMedian() {
        if (lo.size() > hi.size()) {
            return lo.peek();                       // odd count -> middle element
        }
        return (lo.peek() + hi.peek()) / 2.0;       // even count -> average of middles
    }

    public static void main(String[] args) {
        FindMedianFromDataStream mf = new FindMedianFromDataStream();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0
    }
}
