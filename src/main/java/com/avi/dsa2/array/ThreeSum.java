package com.avi.dsa2.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Blind 75 - Array #9: 3Sum
 * ------------------------------------------------------------------
 * Problem:
 *   Return all unique triplets [a,b,c] from nums such that a + b + c = 0.
 *   The solution set must not contain duplicate triplets.
 *
 * Example:
 *   [-1,0,1,2,-1,-4] -> [[-1,-1,2],[-1,0,1]]
 *
 * Approach (sort + two pointers):
 *   Sort the array. Fix the first number nums[i], then find two others in the
 *   remaining part that sum to -nums[i] using the classic two-pointer sweep on
 *   a sorted range: a left pointer and a right pointer move inward based on
 *   whether the current sum is too small or too large. Skip equal neighbours
 *   to avoid duplicate triplets.
 *
 * Complexity:
 *   Time  O(n^2) - outer loop O(n), inner two-pointer O(n).
 *   Space O(1) extra (ignoring the output and sort).
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate anchors
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;   // need a larger sum
                } else {
                    right--;  // need a smaller sum
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(threeSum(new int[]{0, 0, 0}));             // [[0, 0, 0]]
    }
}
