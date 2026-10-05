package com.avi.dsa2.array;

/**
 * Blind 75 - Array #6: Maximum Product Subarray
 * ------------------------------------------------------------------
 * Problem:
 *   Find the contiguous subarray with the largest PRODUCT and return it.
 *
 * Example:
 *   [2,3,-2,4]  -> 6   (subarray [2,3])
 *   [-2,0,-1]   -> 0
 *
 * Approach (track max AND min):
 *   Products are tricky because a negative number flips the sign: a very
 *   small (negative) running product can become the largest after multiplying
 *   by another negative. So at each index we track BOTH the maximum and the
 *   minimum product ending here. When nums[i] is negative we swap them first,
 *   because multiplying by a negative turns the biggest into the smallest and
 *   vice versa.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                // swap: a negative multiplier flips max and min roles.
                int tmp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = tmp;
            }
            maxEndingHere = Math.max(num, maxEndingHere * num);
            minEndingHere = Math.min(num, minEndingHere * num);
            result = Math.max(result, maxEndingHere);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));  // 6
        System.out.println(maxProduct(new int[]{-2, 0, -1}));    // 0
        System.out.println(maxProduct(new int[]{-2, 3, -4}));    // 24
    }
}
