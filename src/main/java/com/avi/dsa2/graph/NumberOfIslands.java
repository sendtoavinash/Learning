package com.avi.dsa2.graph;

/**
 * Blind 75 - Graph #4: Number of Islands
 * ------------------------------------------------------------------
 * Problem:
 *   Given a grid of '1' (land) and '0' (water), count the islands. An island is
 *   land connected horizontally or vertically (not diagonally).
 *
 * Example:
 *   11110
 *   11010
 *   11000
 *   00000   -> 1 island
 *
 * Approach (DFS flood fill):
 *   Scan every cell. Each time we hit unvisited land we found a new island, so
 *   increment the counter and flood-fill (DFS) all connected land, marking it
 *   as water ('0') so we never count the same island twice. The flood fill
 *   spreads in the four cardinal directions.
 *
 * Complexity:
 *   Time  O(rows*cols) - each cell visited once, Space O(rows*cols) recursion.
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c); // erase the whole island
                }
            }
        }
        return count;
    }

    private static void sink(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0'; // mark visited
        sink(grid, r + 1, c);
        sink(grid, r - 1, c);
        sink(grid, r, c + 1);
        sink(grid, r, c - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid)); // 1

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid2)); // 3
    }
}
