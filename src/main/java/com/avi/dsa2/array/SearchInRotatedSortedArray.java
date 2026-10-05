package com.avi.dsa2.array;

/**
 * Blind 75 - Array #8: Search in Rotated Sorted Array
 * ------------------------------------------------------------------
 * Problem:
 *   A sorted ascending array (distinct values) was rotated at an unknown pivot.
 *   Given a target, return its index or -1 if absent. Must run in O(log n).
 *
 * Example:
 *   nums = [4,5,6,7,0,1,2], target = 0 -> 4
 *   nums = [4,5,6,7,0,1,2], target = 3 -> -1
 *
 * Approach (binary search on the sorted half):
 *   At any mid, at least one side (left..mid or mid..right) is still fully
 *   sorted. Detect which side is sorted by comparing endpoints, then check if
 *   the target falls inside that sorted range:
 *     - If left half nums[left..mid] is sorted and target is within it, go left,
 *       else go right.
 *     - Otherwise the right half is sorted; if target is within it go right,
 *       else go left.
 *
 * Complexity:
 *   Time  O(log n), Space O(1).
 */
public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {           // left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {                                 // right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); // 4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); // -1
        System.out.println(search(new int[]{1}, 0));                   // -1
    }
}
