package com.avi.dsa2.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Blind 75 - Graph #5: Longest Consecutive Sequence
 * ------------------------------------------------------------------
 * Problem:
 *   Given an unsorted array, return the length of the longest run of
 *   consecutive integers. Must run in O(n) (so no sorting).
 *
 * Example:
 *   [100,4,200,1,3,2] -> 4  (the run 1,2,3,4)
 *
 * Approach (hash set, start only from sequence beginnings):
 *   Put all numbers in a set for O(1) membership checks. A number n is the
 *   START of a sequence only if n-1 is NOT in the set. From each start we walk
 *   upward (n+1, n+2, ...) counting the run length. Because we only expand from
 *   true starts, every number is visited at most twice overall, giving O(n).
 *
 * Complexity:
 *   Time  O(n), Space O(n).
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {       // num starts a new sequence
                int current = num;
                int length = 1;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));      // 4
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
    }
}
