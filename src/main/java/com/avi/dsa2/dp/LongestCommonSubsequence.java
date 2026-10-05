package com.avi.dsa2.dp;

/**
 * Blind 75 - DP #4: Longest Common Subsequence
 * ------------------------------------------------------------------
 * Problem:
 *   Return the length of the longest subsequence common to two strings. A
 *   subsequence keeps relative order but need not be contiguous.
 *
 * Example:
 *   "abcde", "ace" -> 3  ("ace")
 *   "abc", "def"   -> 0
 *
 * Approach (2D DP grid):
 *   dp[i][j] = LCS length of text1's first i chars and text2's first j chars.
 *     - If the current characters match, they extend the LCS:
 *         dp[i][j] = dp[i-1][j-1] + 1
 *     - Otherwise drop one char from either string and take the better option:
 *         dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 *   Answer is at dp[m][n]. Row/column 0 represent empty prefixes (LCS 0).
 *
 * Complexity:
 *   Time  O(m*n), Space O(m*n).
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println(longestCommonSubsequence("abc", "abc"));   // 3
        System.out.println(longestCommonSubsequence("abc", "def"));   // 0
    }
}
