package com.avi.dsa2.string;

/**
 * Blind 75 - String #7: Valid Palindrome
 * ------------------------------------------------------------------
 * Problem:
 *   Determine if a string is a palindrome considering only alphanumeric
 *   characters and ignoring case.
 *
 * Example:
 *   "A man, a plan, a canal: Panama" -> true
 *   "race a car"                     -> false
 *
 * Approach (two pointers inward):
 *   Walk one pointer from the left and one from the right. Skip any character
 *   that is not alphanumeric. Compare the two characters case-insensitively; if
 *   they ever differ it is not a palindrome. When the pointers meet, all
 *   mirrored pairs matched.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                     // false
        System.out.println(isPalindrome(" "));                              // true
    }
}
