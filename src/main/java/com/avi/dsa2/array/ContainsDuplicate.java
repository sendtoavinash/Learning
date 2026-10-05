package com.avi.dsa2.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Blind 75 - Array #3: Contains Duplicate
 * ------------------------------------------------------------------
 * Problem:
 *   Return true if any value appears at least twice in the array, false if
 *   every element is distinct.
 *
 * Example:
 *   [1,2,3,1] -> true
 *   [1,2,3,4] -> false
 *
 * Approach (Hash Set):
 *   Add each element to a set. A set rejects duplicates, so the moment add()
 *   reports the value was already present we have found a duplicate.
 *
 * Complexity:
 *   Time  O(n), Space O(n).
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) { // add returns false if already present
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1})); // true
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4})); // false
    }
}
