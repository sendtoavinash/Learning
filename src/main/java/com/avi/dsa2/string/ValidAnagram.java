package com.avi.dsa2.string;

/**
 * Blind 75 - String #4: Valid Anagram
 * ------------------------------------------------------------------
 * Problem:
 *   Return true if t is an anagram of s (same characters with the same counts,
 *   just reordered).
 *
 * Example:
 *   s = "anagram", t = "nagaram" -> true
 *   s = "rat", t = "car"         -> false
 *
 * Approach (character frequency counting):
 *   Anagrams must be the same length and have identical letter frequencies.
 *   Increment a count array for each char in s and decrement for each char in t.
 *   If the strings are anagrams every count ends at zero; any non-zero count
 *   means a mismatch. (Shown with a 26-slot array for lowercase letters.)
 *
 * Complexity:
 *   Time  O(n), Space O(1) - fixed 26-letter array.
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}
