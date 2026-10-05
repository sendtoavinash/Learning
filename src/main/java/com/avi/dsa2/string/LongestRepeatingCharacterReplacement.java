package com.avi.dsa2.string;

/**
 * Blind 75 - String #2: Longest Repeating Character Replacement
 * ------------------------------------------------------------------
 * Problem:
 *   You may replace at most k characters of s with any uppercase letter. Return
 *   the length of the longest substring that can be made of a single repeated
 *   character after at most k replacements.
 *
 * Example:
 *   s = "ABAB", k = 2 -> 4  (change both A's to B or vice versa)
 *   s = "AABABBA", k = 1 -> 4
 *
 * Approach (sliding window + most-frequent count):
 *   For a window to be fixable, the number of characters we must replace equals
 *   windowLength - (count of the most frequent character in the window). If that
 *   exceeds k the window is too big, so shrink from the left. We track per-char
 *   counts and the running max frequency; the largest valid window seen is the
 *   answer.
 *
 * Complexity:
 *   Time  O(n), Space O(1) - 26-letter count array.
 */
public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxFreq = 0, result = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // chars to replace = windowLen - maxFreq; if > k, shrink.
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));    // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
    }
}
