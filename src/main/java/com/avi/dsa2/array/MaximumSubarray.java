package com.avi.dsa2.array;

/**
 * Blind 75 - Array #5: Maximum Subarray (Kadane's Algorithm)
 * ------------------------------------------------------------------
 * Problem:
 *   Find the contiguous subarray with the largest sum and return that sum.
 *
 * Example:
 *   [-2,1,-3,4,-1,2,1,-5,4] -> 6  (subarray [4,-1,2,1])
 *
 * Approach (Kadane's):
 *   Walk through the array keeping currentSum, the best sum of a subarray that
 *   ENDS at the current index. At each element we decide: extend the previous
 *   subarray (currentSum + num) or start fresh at num. We start fresh whenever
 *   the previous sum was negative (it would only drag us down). Track the
 *   global maximum of all these ending sums.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Either extend the running subarray or restart at nums[i].
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{1}));         // 1
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8})); // 23
    }
}
