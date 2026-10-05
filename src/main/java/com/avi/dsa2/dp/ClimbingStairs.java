package com.avi.dsa2.dp;

/**
 * Blind 75 - DP #1: Climbing Stairs
 * ------------------------------------------------------------------
 * Problem:
 *   You climb a staircase of n steps. Each move you take 1 or 2 steps. How many
 *   distinct ways can you reach the top?
 *
 * Example:
 *   n = 2 -> 2  (1+1, 2)
 *   n = 3 -> 3  (1+1+1, 1+2, 2+1)
 *
 * Approach (Fibonacci-style DP):
 *   To reach step n your last move was either from step n-1 (a single step) or
 *   from step n-2 (a double step). So ways(n) = ways(n-1) + ways(n-2) - exactly
 *   the Fibonacci recurrence. We only need the last two values, so two rolling
 *   variables suffice instead of a full array.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int oneStepBack = 2; // ways to reach step i-1
        int twoStepsBack = 1; // ways to reach step i-2
        for (int i = 3; i <= n; i++) {
            int current = oneStepBack + twoStepsBack;
            twoStepsBack = oneStepBack;
            oneStepBack = current;
        }
        return oneStepBack;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 2
        System.out.println(climbStairs(3)); // 3
        System.out.println(climbStairs(5)); // 8
    }
}
