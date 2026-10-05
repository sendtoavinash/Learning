package com.avi.dsa2.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Blind 75 - DP #5: Word Break
 * ------------------------------------------------------------------
 * Problem:
 *   Given a string s and a dictionary of words, determine if s can be segmented
 *   into a space-separated sequence of one or more dictionary words.
 *
 * Example:
 *   s = "leetcode", dict = ["leet","code"] -> true
 *   s = "catsandog", dict = ["cats","dog","sand","and","cat"] -> false
 *
 * Approach (bottom-up DP):
 *   dp[i] = true means s[0..i) can be fully segmented. dp[0] = true (empty
 *   string). For each end position i, look for a split point j < i such that
 *   dp[j] is true (prefix is breakable) AND s[j..i) is a dictionary word. If any
 *   such j exists, dp[i] is true. Answer is dp[s.length()].
 *
 * Complexity:
 *   Time  O(n^2) splits * O(k) substring, Space O(n).
 */
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty prefix is always segmentable
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));                    // true
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));               // true
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); // false
    }
}
