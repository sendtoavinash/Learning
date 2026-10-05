package com.avi.dsa2.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Blind 75 - String #5: Group Anagrams
 * ------------------------------------------------------------------
 * Problem:
 *   Group a list of strings so that anagrams of each other are in the same
 *   group.
 *
 * Example:
 *   ["eat","tea","tan","ate","nat","bat"]
 *   -> [["eat","tea","ate"],["tan","nat"],["bat"]]
 *
 * Approach (canonical key via sorting):
 *   Two words are anagrams exactly when their sorted characters match. So we map
 *   each word to the sorted version of its letters and use that as a key in a
 *   hash map; every word that shares a key lands in the same bucket.
 *   (A character-count signature would also work and is O(n) per word.)
 *
 * Complexity:
 *   Time  O(n * k log k) where k is max word length, Space O(n * k).
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // canonical anagram signature
            groups.computeIfAbsent(key, x -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // [[eat, tea, ate], [tan, nat], [bat]]  (order of groups may vary)
    }
}
