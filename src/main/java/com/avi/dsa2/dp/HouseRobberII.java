package com.avi.dsa2.dp;

/**
 * Blind 75 - DP #8: House Robber II
 * ------------------------------------------------------------------
 * Problem:
 *   Same as House Robber, but the houses are arranged in a CIRCLE: the first
 *   and last houses are now adjacent, so you cannot rob both.
 *
 * Example:
 *   [2,3,2]   -> 3  (cannot take houses 0 and 2 together)
 *   [1,2,3,1] -> 4
 *
 * Approach (two linear passes):
 *   The circular constraint means the first and last houses are mutually
 *   exclusive. So the answer is the better of two straight-line subproblems:
 *     1. Rob houses [0 .. n-2]  (allow first, exclude last).
 *     2. Rob houses [1 .. n-1]  (exclude first, allow last).
 *   Each subproblem is the plain House Robber solved with rolling DP.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(
                robLine(nums, 0, nums.length - 2),
                robLine(nums, 1, nums.length - 1)
        );
    }

    private static int robLine(int[] nums, int start, int end) {
        int prev = 0, curr = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));    // 3
        System.out.println(rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(rob(new int[]{1, 2, 3}));    // 3
    }
}
