package com.avi.dsa2.matrix;

import java.util.Arrays;

/**
 * Blind 75 - Matrix #1: Set Matrix Zeroes
 * ------------------------------------------------------------------
 * Problem:
 *   If an element in an m x n matrix is 0, set its ENTIRE row and column to 0.
 *   Do it in place using O(1) extra space.
 *
 * Example:
 *   [[1,1,1],[1,0,1],[1,1,1]] -> [[1,0,1],[0,0,0],[1,0,1]]
 *
 * Approach (use first row/column as markers):
 *   We cannot zero cells as we find them, or the zeros would cascade. Instead
 *   use the matrix's own first row and first column as bookmarks: if cell (r,c)
 *   is 0, mark matrix[r][0] and matrix[0][c] as 0. Two boolean flags remember
 *   whether the first row/column themselves need zeroing. Then zero the inner
 *   cells based on the marks, and finally handle the first row/column.
 *
 * Complexity:
 *   Time  O(m*n), Space O(1).
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // detect whether first row / column must be zeroed
        for (int c = 0; c < cols; c++) if (matrix[0][c] == 0) firstRowZero = true;
        for (int r = 0; r < rows; r++) if (matrix[r][0] == 0) firstColZero = true;

        // use first row/col as markers for the inner matrix
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        // zero inner cells based on the markers
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }
        // finally zero the first row/column if needed
        if (firstRowZero) Arrays.fill(matrix[0], 0);
        if (firstColZero) for (int r = 0; r < rows; r++) matrix[r][0] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        // [[1, 0, 1], [0, 0, 0], [1, 0, 1]]
    }
}
