package com.avi.dsa2.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Blind 75 - Matrix #2: Spiral Matrix
 * ------------------------------------------------------------------
 * Problem:
 *   Return all elements of an m x n matrix in spiral order (clockwise, starting
 *   from the top-left).
 *
 * Example:
 *   [[1,2,3],[4,5,6],[7,8,9]] -> [1,2,3,6,9,8,7,4,5]
 *
 * Approach (shrinking boundaries):
 *   Keep four boundaries: top, bottom, left, right. Walk the top row left->right,
 *   the right column top->bottom, the bottom row right->left, and the left
 *   column bottom->top, shrinking the relevant boundary after each pass. Stop
 *   when the boundaries cross. The inner checks (top <= bottom, left <= right)
 *   guard against double-processing the middle row/column of odd-sized grids.
 *
 * Complexity:
 *   Time  O(m*n), Space O(1) extra (besides output).
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) result.add(matrix[top][c]);       // top row
            top++;
            for (int r = top; r <= bottom; r++) result.add(matrix[r][right]);     // right col
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) result.add(matrix[bottom][c]); // bottom row
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) result.add(matrix[r][left]);   // left col
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }
}
