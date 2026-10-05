package com.avi.dsa2.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Blind 75 - DP #6: Combination Sum
 * ------------------------------------------------------------------
 * Problem:
 *   Given distinct candidates and a target, return all unique combinations that
 *   sum to target. Each candidate may be used an UNLIMITED number of times.
 *   Combinations that use the same numbers in a different order count once.
 *
 * Example:
 *   candidates = [2,3,6,7], target = 7 -> [[2,2,3],[7]]
 *
 * Approach (backtracking):
 *   Explore a decision tree. At each step we either keep using the current
 *   candidate (allowed because reuse is unlimited, so we do NOT advance the
 *   index) or move on to the next candidate. Passing a start index forward
 *   prevents producing the same multiset in a different order (so [2,2,3] but
 *   not [3,2,2]). We prune when the remaining target goes negative.
 *
 * Complexity:
 *   Time  exponential in the number of combinations, Space O(target/min).
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int remaining, int start,
                                  List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current)); // found a valid combination
            return;
        }
        if (remaining < 0) return; // overshot, prune

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // i (not i+1) because the same candidate can be reused.
            backtrack(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1); // undo the choice
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7)); // [[2, 2, 3], [7]]
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));    // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
    }
}
