package com.avi.dsa2.array;

/**
 * Blind 75 - Array #7: Find Minimum in Rotated Sorted Array
 * ------------------------------------------------------------------
 * Problem:
 *   A sorted ascending array was rotated at some unknown pivot (e.g.
 *   [0,1,2,4,5,6,7] -> [4,5,6,7,0,1,2]). Find the minimum element in O(log n).
 *   All elements are distinct.
 *
 * Example:
 *   [3,4,5,1,2]       -> 1
 *   [4,5,6,7,0,1,2]   -> 0
 *
 * Approach (modified binary search):
 *   The minimum is the single "inflection" point where order breaks. Compare
 *   nums[mid] with nums[right]:
 *     - If nums[mid] > nums[right], the smallest value must be to the RIGHT of
 *       mid (the rotation happened there), so move left = mid + 1.
 *     - Otherwise the smallest is at mid or to its LEFT, so move right = mid.
 *   The loop narrows to the minimum.
 *
 * Complexity:
 *   Time  O(log n), Space O(1).
 */
public class FindMinInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;   // min is in the right half
            } else {
                right = mid;      // min is at mid or in the left half
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));       // 1
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(findMin(new int[]{11, 13, 15, 17}));      // 11
    }
}
