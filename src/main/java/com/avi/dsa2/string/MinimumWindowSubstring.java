package com.avi.dsa2.string;

/**
 * Blind 75 - String #3: Minimum Window Substring
 * ------------------------------------------------------------------
 * Problem:
 *   Given strings s and t, return the smallest substring of s that contains all
 *   characters of t (including duplicates). Return "" if none exists.
 *
 * Example:
 *   s = "ADOBECODEBANC", t = "ABC" -> "BANC"
 *
 * Approach (sliding window with character counts):
 *   Count how many of each character t needs. Expand the window's right edge,
 *   decrementing need counts; track "have" = how many required characters are
 *   currently satisfied. Once the window contains all of t (have == required),
 *   try to shrink from the left to find the smallest valid window, updating the
 *   best answer, and stop shrinking as soon as a required character drops out.
 *
 * Complexity:
 *   Time  O(|s| + |t|), Space O(unique chars).
 */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        int required = t.length();

        int left = 0, bestStart = 0, bestLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (need[s.charAt(right)]-- > 0) required--; // consumed a needed char
            while (required == 0) {                      // window is valid, shrink it
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                if (need[s.charAt(left)]++ == 0) required++; // left char becomes needed again
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("a", "a"));               // a
        System.out.println(minWindow("a", "aa"));              // "" (empty)
    }
}
