package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #12: Implement Trie (Prefix Tree)
 * ------------------------------------------------------------------
 * Problem:
 *   Implement a trie supporting insert(word), search(word) (exact match), and
 *   startsWith(prefix).
 *
 * Example:
 *   insert("apple"); search("apple") -> true; search("app") -> false;
 *   startsWith("app") -> true; insert("app"); search("app") -> true.
 *
 * Approach (26-way child nodes):
 *   Each trie node holds up to 26 children (one per lowercase letter) and a flag
 *   marking whether a word ends there. insert walks/creates a path of nodes for
 *   the word and flags the final node. search follows the path and checks the
 *   end flag; startsWith just checks the path exists. Shared prefixes reuse the
 *   same nodes, which is what makes prefix queries fast.
 *
 * Complexity:
 *   Time  O(wordLength) per operation, Space O(total characters inserted).
 */
public class ImplementTrie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) return null;
            node = node.children[idx];
        }
        return node;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));     // true
        System.out.println(trie.search("app"));       // false
        System.out.println(trie.startsWith("app"));   // true
        trie.insert("app");
        System.out.println(trie.search("app"));       // true
    }
}
