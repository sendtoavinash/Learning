package com.avi.dsa2.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Blind 75 - Array #1: Two Sum
 * ------------------------------------------------------------------
 * Problem:
 *   Given an array of integers nums and an integer target, return the
 *   indices of the two numbers such that they add up to target.
 *   Exactly one solution exists and you may not use the same element twice.
 *
 * Example:
 *   nums = [2,7,11,15], target = 9  ->  [0,1]  (because 2 + 7 = 9)
 *
 * Approach (Hash Map, one pass):
 *   For each number x we need (target - x) to complete the pair. Instead of
 *   searching the rest of the array (O(n) per element -> O(n^2) total), we
 *   remember every number we have already seen in a map of value -> index.
 *   While scanning, if the complement is already in the map we found the pair.
 *
 * Complexity:
 *   Time  O(n) - single pass, each map lookup/insert is O(1) average.
 *   Space O(n) - the map can hold up to n entries.
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        return new int[]{}; // no pair found
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));      // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));         // [0, 1]
    }
}
