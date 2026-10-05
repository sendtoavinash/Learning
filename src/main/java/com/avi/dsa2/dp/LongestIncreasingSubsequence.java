package com.avi.dsa2.dp;

import java.util.Arrays;

/**
 * Blind 75 - DP #3: Longest Increasing Subsequence
 * ------------------------------------------------------------------
 * Problem:
 *   Return the length of the longest strictly increasing subsequence
 *   (not necessarily contiguous).
 *
 * Example:
 *   [10,9,2,5,3,7,101,18] -> 4  (e.g. [2,3,7,101])
 *
 * Approach (patience sorting / binary search, O(n log n)):
 *   Maintain a "tails" array where tails[k] is the smallest possible tail value
 *   of an increasing subsequence of length k+1. For each number:
 *     - Binary search for the first tail >= num.
 *     - If none exists, num extends the longest run -> append it.
 *     - Otherwise replace that tail with num, keeping tails as small as
 *       possible so future numbers have more room to extend.
 *   The length of tails is the answer. (tails is not a real subsequence, but
 *   its length is correct.)
 *
 * Complexity:
 *   Time  O(n log n), Space O(n).
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int lo = 0, hi = size;
            while (lo < hi) {               // binary search for first tail >= num
                int mid = (lo + hi) / 2;
                if (tails[mid] < num) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = num;                // place/replace
            if (lo == size) size++;         // extended the longest run
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
        System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));           // 4
        System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7}));                 // 1
    }
}
