package com.avi.dsa2.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Blind 75 - Tree #14: Word Search II
 * ------------------------------------------------------------------
 * Problem:
 *   Given a board of characters and a list of words, return all words that can
 *   be formed from sequentially adjacent cells (no cell reused per word).
 *
 * Example:
 *   board = [[o,a,a,n],[e,t,a,e],[i,h,k,r],[i,f,l,v]],
 *   words = ["oath","pea","eat","rain"] -> ["oath","eat"]
 *
 * Approach (Trie + DFS backtracking):
 *   Searching each word independently is slow. Instead build a trie of ALL
 *   words, then DFS the board once. At each step we only continue if the current
 *   letter is a child in the trie, so many dead paths are pruned early. When a
 *   trie node marks the end of a word we record it. We store the full word on
 *   the end node for easy collection and null it out after adding to avoid
 *   duplicates. Cells are marked '#' during a path and restored on backtrack.
 *
 * Complexity:
 *   Time  O(cells * 4^maxWordLen) worst case, pruned heavily by the trie.
 *   Space O(total characters in words).
 */
public class WordSearchII {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // non-null only at the end of a complete word
    }

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) node.children[idx] = new TrieNode();
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }

    private static void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];
        if (node.word != null) {         // found a complete word
            result.add(node.word);
            node.word = null;            // avoid adding it twice
        }

        board[r][c] = '#';               // mark visited
        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);
        board[r][c] = ch;                // restore on backtrack
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words)); // [oath, eat]
    }
}
