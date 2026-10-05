package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #13: Add and Search Word (Design, with '.' wildcard)
 * ------------------------------------------------------------------
 * Problem:
 *   Design a data structure supporting addWord(word) and search(word), where in
 *   search a '.' can match ANY single letter.
 *
 * Example:
 *   addWord("bad"); addWord("dad"); addWord("mad");
 *   search("pad") -> false; search("bad") -> true;
 *   search(".ad") -> true;   search("b..") -> true.
 *
 * Approach (trie + DFS for wildcards):
 *   Store words in a trie exactly like a normal prefix tree. search walks the
 *   trie, but when it hits a '.', it cannot pick a single child - it must try
 *   ALL non-null children recursively and succeed if any branch matches the
 *   rest of the pattern. Non-wildcard characters follow the one matching child.
 *
 * Complexity:
 *   Time  O(wordLength) for add; search is O(26^(dots) * length) worst case.
 *   Space O(total characters).
 */
public class AddAndSearchWord {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private final TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isWord;

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children) {   // wildcard: try every child
                if (dfs(word, index + 1, child)) return true;
            }
            return false;
        }
        return dfs(word, index + 1, node.children[c - 'a']);
    }

    public static void main(String[] args) {
        AddAndSearchWord dict = new AddAndSearchWord();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        System.out.println(dict.search("pad"));  // false
        System.out.println(dict.search("bad"));  // true
        System.out.println(dict.search(".ad"));  // true
        System.out.println(dict.search("b.."));  // true
    }
}
