package com.avi.dsa2.array;

import java.util.Arrays;

/**
 * Blind 75 - Array #4: Product of Array Except Self
 * ------------------------------------------------------------------
 * Problem:
 *   Return an array output where output[i] is the product of all elements of
 *   nums except nums[i]. You must solve it WITHOUT using division and in O(n).
 *
 * Example:
 *   [1,2,3,4] -> [24,12,8,6]
 *
 * Approach (prefix & suffix products):
 *   output[i] = (product of everything to the LEFT of i)
 *             * (product of everything to the RIGHT of i).
 *   Pass 1 (left to right): store the running product of all elements before i.
 *   Pass 2 (right to left): multiply by the running product of all elements
 *   after i. This avoids division and keeps it O(n) with O(1) extra space
 *   (the output array itself does not count as extra).
 *
 * Complexity:
 *   Time  O(n), Space O(1) extra (besides the output array).
 */
public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // result[i] holds product of all elements to the left of i.
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // multiply by product of all elements to the right of i.
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));   // [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // [0, 0, 9, 0, 0]
    }
}
