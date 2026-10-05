package com.avi.dsa2.binary;

/**
 * Blind 75 - Binary #4: Missing Number
 * ------------------------------------------------------------------
 * Problem:
 *   nums contains n distinct numbers taken from the range [0, n] (so exactly
 *   one number in that range is missing). Return the missing number.
 *
 * Example:
 *   [3,0,1]       -> 2
 *   [9,6,4,2,3,5,7,0,1] -> 8
 *
 * Approach (XOR):
 *   XOR has two handy properties: x ^ x = 0 and x ^ 0 = x. If we XOR together
 *   every index 0..n AND every value in nums, each number that appears in both
 *   cancels out, leaving only the one index that has no matching value - the
 *   missing number. This avoids overflow that a sum-based approach could hit.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int xor = nums.length; // start with n (the largest index)
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));                   // 2
        System.out.println(missingNumber(new int[]{0, 1}));                      // 2
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // 8
    }
}
