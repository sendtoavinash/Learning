package com.avi.dsa2.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Blind 75 - Graph #3: Pacific Atlantic Water Flow
 * ------------------------------------------------------------------
 * Problem:
 *   An m x n grid of heights. The Pacific ocean touches the top and left edges,
 *   the Atlantic touches the bottom and right edges. Water flows from a cell to
 *   a neighbour of EQUAL or LOWER height. Return all cells from which water can
 *   reach BOTH oceans.
 *
 * Example:
 *   Classic 5x5 LeetCode grid -> [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 *
 * Approach (reverse DFS from each ocean):
 *   Instead of asking "can this cell reach the ocean?" for every cell (costly),
 *   flip it: start from the ocean borders and climb INLAND to cells of equal or
 *   GREATER height (reverse of the flow rule). Mark everything reachable from
 *   the Pacific border, then everything reachable from the Atlantic border. The
 *   answer is the intersection - cells reachable from both.
 *
 * Complexity:
 *   Time  O(m*n), Space O(m*n).
 */
public class PacificAtlantic {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0, Integer.MIN_VALUE);          // left edge -> Pacific
            dfs(heights, atlantic, r, cols - 1, Integer.MIN_VALUE);  // right edge -> Atlantic
        }
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c, Integer.MIN_VALUE);          // top edge -> Pacific
            dfs(heights, atlantic, rows - 1, c, Integer.MIN_VALUE);  // bottom edge -> Atlantic
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] heights, boolean[][] visited, int r, int c, int prevHeight) {
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return; // water cannot climb to a lower cell going inland

        visited[r][c] = true;
        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }

    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(pacificAtlantic(heights));
        // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
    }
}
