package com.avi.dsa2.matrix;

import java.util.Arrays;

/**
 * Blind 75 - Matrix #3: Rotate Image
 * ------------------------------------------------------------------
 * Problem:
 *   Rotate an n x n matrix 90 degrees clockwise, IN PLACE (no extra matrix).
 *
 * Example:
 *   [[1,2,3],[4,5,6],[7,8,9]] -> [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Approach (transpose then reverse each row):
 *   A 90-degree clockwise rotation equals two simple operations:
 *     1. Transpose - swap matrix[i][j] with matrix[j][i], flipping over the
 *        main diagonal.
 *     2. Reverse each row - mirror horizontally.
 *   Doing both in place avoids allocating a second matrix.
 *
 * Complexity:
 *   Time  O(n^2), Space O(1).
 */
public class RotateImage {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // 1. transpose over the main diagonal
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 2. reverse each row
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = n - 1;
            while (lo < hi) {
                int temp = matrix[i][lo];
                matrix[i][lo] = matrix[i][hi];
                matrix[i][hi] = temp;
                lo++;
                hi--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    }
}
