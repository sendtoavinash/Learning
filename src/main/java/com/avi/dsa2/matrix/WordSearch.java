package com.avi.dsa2.matrix;

/**
 * Blind 75 - Matrix #4: Word Search
 * ------------------------------------------------------------------
 * Problem:
 *   Given a grid of characters and a word, return true if the word can be built
 *   from sequentially adjacent cells (horizontal/vertical neighbours). The same
 *   cell may NOT be reused within one word.
 *
 * Example:
 *   board = [[A,B,C,E],[S,F,C,S],[A,D,E,E]], word = "ABCCED" -> true
 *   same board, word = "ABCB" -> false
 *
 * Approach (DFS backtracking):
 *   Try to start the word at every cell. From a matching cell, recurse into the
 *   four neighbours looking for the next character. Temporarily mark the current
 *   cell as visited (overwrite with '#') so the path cannot reuse it, then
 *   restore it when backtracking. Succeed when every character is matched.
 *
 * Complexity:
 *   Time  O(rows*cols * 4^len), Space O(len) recursion depth.
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) return true; // matched the whole word
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
                || board[r][c] != word.charAt(index)) {
            return false;
        }

        char saved = board[r][c];
        board[r][c] = '#'; // mark visited to prevent reuse
        boolean found = dfs(board, word, r + 1, c, index + 1)
                || dfs(board, word, r - 1, c, index + 1)
                || dfs(board, word, r, c + 1, index + 1)
                || dfs(board, word, r, c - 1, index + 1);
        board[r][c] = saved; // restore on backtrack
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE"));    // true
        System.out.println(exist(board, "ABCB"));   // false
    }
}
