package com.avi.dsa2.binary;

import java.util.Arrays;

/**
 * Blind 75 - Binary #3: Counting Bits
 * ------------------------------------------------------------------
 * Problem:
 *   For every number i in the range 0..n, return an array where result[i] is
 *   the count of 1-bits in i.
 *
 * Example:
 *   n = 5 -> [0,1,1,2,1,2]
 *
 * Approach (DP using i >> 1):
 *   The number i has the same 1-bits as i/2 (i >> 1), plus one more if i is odd
 *   (its lowest bit is set). So:
 *       result[i] = result[i >> 1] + (i & 1)
 *   Since i >> 1 < i, that subproblem is already solved. This builds the whole
 *   table in a single pass instead of counting each number from scratch.
 *
 * Complexity:
 *   Time  O(n), Space O(n) for the output table.
 */
public class CountingBits {

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5))); // [0, 1, 1, 2, 1, 2]
        System.out.println(Arrays.toString(countBits(2))); // [0, 1, 1]
    }
}
