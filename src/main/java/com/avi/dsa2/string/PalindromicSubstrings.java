package com.avi.dsa2.string;

/**
 * Blind 75 - String #9: Palindromic Substrings
 * ------------------------------------------------------------------
 * Problem:
 *   Count how many substrings of s are palindromes. Single characters count,
 *   and substrings at different positions count separately even if equal.
 *
 * Example:
 *   "abc" -> 3  ("a","b","c")
 *   "aaa" -> 6  ("a","a","a","aa","aa","aaa")
 *
 * Approach (expand around center):
 *   Same centers idea as Longest Palindromic Substring: 2n-1 centers (each
 *   character and each gap). From every center expand outward; each successful
 *   expansion (both sides equal) is one more palindromic substring, so we count
 *   each expansion step rather than just tracking the longest.
 *
 * Complexity:
 *   Time  O(n^2), Space O(1).
 */
public class PalindromicSubstrings {

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);     // odd-length palindromes
            count += expand(s, i, i + 1); // even-length palindromes
        }
        return count;
    }

    private static int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; // found one more palindrome centered here
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc")); // 3
        System.out.println(countSubstrings("aaa")); // 6
    }
}
