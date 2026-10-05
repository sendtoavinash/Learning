package com.avi.dsa2.array;

/**
 * Blind 75 - Array #10: Container With Most Water
 * ------------------------------------------------------------------
 * Problem:
 *   Each height[i] is a vertical line at position i. Pick two lines that with
 *   the x-axis form a container holding the most water. Return that max area.
 *
 * Example:
 *   [1,8,6,2,5,4,8,3,7] -> 49  (lines at index 1 and 8: min(8,7) * (8-1) = 49)
 *
 * Approach (two pointers from both ends):
 *   Area = (distance between the two lines) * (height of the shorter line).
 *   Start with the widest possible container (first and last line). Moving the
 *   taller line inward can only shrink both the width and the limiting height,
 *   so it never helps; moving the SHORTER line inward is the only way to
 *   possibly find a taller limiting wall. So always advance the shorter side.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * h);
            if (height[left] < height[right]) {
                left++;   // move the shorter wall hoping for a taller one
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{1, 1}));                      // 1
    }
}
