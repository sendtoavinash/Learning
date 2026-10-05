package com.avi.dsa2.dp;

/**
 * Blind 75 - DP #11: Jump Game
 * ------------------------------------------------------------------
 * Problem:
 *   Each nums[i] is the maximum jump length from index i. Starting at index 0,
 *   determine whether you can reach the last index.
 *
 * Example:
 *   [2,3,1,1,4] -> true
 *   [3,2,1,0,4] -> false (you get stuck at index 3)
 *
 * Approach (greedy, track furthest reach):
 *   Sweep left to right keeping the furthest index reachable so far. At each
 *   index i, if i is beyond that reach we can never land on it, so return false.
 *   Otherwise extend the reach with i + nums[i]. If the reach ever covers the
 *   last index we succeed. This greedy stays O(n) because we never need to
 *   enumerate individual jump sequences.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class JumpGame {

    public static boolean canJump(int[] nums) {
        int furthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > furthest) return false;          // unreachable gap
            furthest = Math.max(furthest, i + nums[i]);
            if (furthest >= nums.length - 1) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4})); // false
    }
}
