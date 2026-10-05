package com.avi.dsa2.string;

/**
 * Blind 75 - String #8: Longest Palindromic Substring
 * ------------------------------------------------------------------
 * Problem:
 *   Return the longest substring of s that reads the same forwards and
 *   backwards.
 *
 * Example:
 *   "babad" -> "bab" (or "aba")
 *   "cbbd"  -> "bb"
 *
 * Approach (expand around center):
 *   Every palindrome has a center. There are 2n-1 possible centers: n single
 *   characters (odd-length palindromes) and n-1 gaps between characters
 *   (even-length palindromes). From each center expand outward while the two
 *   sides match, recording the longest palindrome found.
 *
 * Complexity:
 *   Time  O(n^2), Space O(1).
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = expand(s, i, i);     // odd-length center
            int even = expand(s, i, i + 1); // even-length center
            int len = Math.max(odd, even);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of the palindrome
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // bab (or aba)
        System.out.println(longestPalindrome("cbbd"));  // bb
    }
}
