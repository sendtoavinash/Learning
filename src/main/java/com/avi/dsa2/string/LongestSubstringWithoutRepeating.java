package com.avi.dsa2.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Blind 75 - String #1: Longest Substring Without Repeating Characters
 * ------------------------------------------------------------------
 * Problem:
 *   Return the length of the longest substring of s with all distinct
 *   characters.
 *
 * Example:
 *   "abcabcbb" -> 3  ("abc")
 *   "bbbbb"    -> 1  ("b")
 *   "pwwkew"   -> 3  ("wke")
 *
 * Approach (sliding window + last-seen map):
 *   Keep a window [left, right] of unique characters. As right advances, if the
 *   current character was seen inside the current window, jump left to just
 *   past that previous occurrence (so the window stays duplicate-free). Record
 *   each character's latest index and track the maximum window width.
 *
 * Complexity:
 *   Time  O(n), Space O(min(n, charset)).
 */
public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1; // skip past the duplicate
            }
            lastSeen.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    }
}
