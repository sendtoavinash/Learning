package com.avi.dsa2.dp;

/**
 * Blind 75 - DP #10: Unique Paths
 * ------------------------------------------------------------------
 * Problem:
 *   A robot starts at the top-left of an m x n grid and wants to reach the
 *   bottom-right. It can only move right or down. Count the distinct paths.
 *
 * Example:
 *   m = 3, n = 7 -> 28
 *   m = 3, n = 2 -> 3
 *
 * Approach (DP, compressed to one row):
 *   The number of ways to reach a cell equals ways-from-above + ways-from-left,
 *   because those are the only two cells that can move into it. The first row
 *   and first column have exactly one path (straight line). Instead of a full
 *   2D table we keep a single row and update it in place: dp[j] += dp[j-1]
 *   folds in the "from the left" contribution while dp[j]'s old value is the
 *   "from above" contribution.
 *
 * Complexity:
 *   Time  O(m*n), Space O(n).
 */
public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1); // first row: one path to each cell
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // from above (old dp[j]) + from left (dp[j-1])
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // 28
        System.out.println(uniquePaths(3, 2)); // 3
    }
}
