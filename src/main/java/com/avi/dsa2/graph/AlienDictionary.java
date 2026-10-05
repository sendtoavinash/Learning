package com.avi.dsa2.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Blind 75 - Graph #6: Alien Dictionary
 * ------------------------------------------------------------------
 * Problem:
 *   A list of words is sorted lexicographically according to an unknown alien
 *   alphabet. Derive a possible ordering of the alien letters. Return "" if the
 *   ordering is invalid (contradiction) or undetermined by the given words.
 *
 * Example:
 *   ["wrt","wrf","er","ett","rftt"] -> "wertf"
 *   ["z","x"]                        -> "zx"
 *   ["z","x","z"]                    -> ""   (contradiction)
 *
 * Approach (build graph from adjacent words + topological sort):
 *   Compare each adjacent pair of words; the FIRST differing character tells us
 *   one ordering rule (c1 comes before c2). Edge case: if a word is a prefix of
 *   the one AFTER it (e.g. "abc" before "ab"), that is invalid -> "". Build a
 *   directed graph of these rules, then run Kahn's topological sort. If a cycle
 *   prevents ordering all letters, return "".
 *
 * Complexity:
 *   Time  O(total characters), Space O(unique letters + edges).
 */
public class AlienDictionary {

    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Register every letter so isolated ones still appear in the output.
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

        // Derive ordering rules from adjacent word pairs.
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i], second = words[i + 1];
            int minLen = Math.min(first.length(), second.length());
            if (first.length() > second.length() && first.startsWith(second)) {
                return ""; // "abc" before "ab" is invalid
            }
            for (int j = 0; j < minLen; j++) {
                char c1 = first.charAt(j), c2 = second.charAt(j);
                if (c1 != c2) {
                    if (graph.get(c1).add(c2)) {
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    break; // only the first difference matters
                }
            }
        }

        // Kahn's topological sort.
        Queue<Character> queue = new ArrayDeque<>();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) queue.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            for (char next : graph.get(ch)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) queue.offer(next);
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : ""; // cycle check
    }

    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"})); // wertf
        System.out.println(alienOrder(new String[]{"z", "x"}));                           // zx
        System.out.println(alienOrder(new String[]{"z", "x", "z"}));                      // "" (empty)
    }
}
