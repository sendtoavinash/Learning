package com.avi.dsa2.dp;

/**
 * Blind 75 - DP #9: Decode Ways
 * ------------------------------------------------------------------
 * Problem:
 *   A message of digits is encoded with A=1 ... Z=26. Count how many ways the
 *   string can be decoded. For example "12" can be "AB" (1,2) or "L" (12).
 *
 * Example:
 *   "12"  -> 2  ("AB", "L")
 *   "226" -> 3  ("BZ", "VF", "BBF")
 *   "06"  -> 0  (leading zero is invalid)
 *
 * Approach (Fibonacci-style DP):
 *   dp[i] = number of ways to decode the first i characters.
 *     - If the single digit s[i-1] is 1..9 it can stand alone -> add dp[i-1].
 *     - If the two digits s[i-2..i-1] form 10..26 they decode as one letter ->
 *       add dp[i-2].
 *   Zeros are the tricky part: a '0' must pair with a preceding 1 or 2, else the
 *   string is undecodable. dp[0] = 1 represents the empty prefix.
 *
 * Complexity:
 *   Time  O(n), Space O(1) with rolling variables.
 */
public class DecodeWays {

    public static int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') return 0;
        int twoBack = 1; // dp[i-2], empty prefix
        int oneBack = 1; // dp[i-1]
        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current += oneBack; // single-digit decode
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBack; // two-digit decode
            }
            if (current == 0) return 0; // dead end (e.g. invalid 0)
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));  // 2
        System.out.println(numDecodings("226")); // 3
        System.out.println(numDecodings("06"));  // 0
    }
}
