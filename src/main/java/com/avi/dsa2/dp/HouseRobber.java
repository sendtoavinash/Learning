package com.avi.dsa2.dp;

/**
 * Blind 75 - DP #7: House Robber
 * ------------------------------------------------------------------
 * Problem:
 *   Houses in a row each hold some money. You cannot rob two ADJACENT houses
 *   (alarms connect them). Return the maximum money you can rob.
 *
 * Example:
 *   [1,2,3,1]   -> 4  (rob house 0 and 2: 1 + 3)
 *   [2,7,9,3,1] -> 12 (rob house 0, 2, 4: 2 + 9 + 1)
 *
 * Approach (rolling DP):
 *   For each house you choose: skip it (keep the best up to the previous house)
 *   or rob it (its money plus the best up to two houses back, since adjacency is
 *   forbidden). So best(i) = max(best(i-1), nums[i] + best(i-2)). We only need
 *   the two previous results, kept in two rolling variables.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class HouseRobber {

    public static int rob(int[] nums) {
        int prev = 0;    // best up to house i-2
        int curr = 0;    // best up to house i-1
        for (int money : nums) {
            int temp = Math.max(curr, prev + money);
            prev = curr;
            curr = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));    // 4
        System.out.println(rob(new int[]{2, 7, 9, 3, 1})); // 12
    }
}
