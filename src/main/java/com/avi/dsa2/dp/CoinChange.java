package com.avi.dsa2.dp;

import java.util.Arrays;

/**
 * Blind 75 - DP #2: Coin Change
 * ------------------------------------------------------------------
 * Problem:
 *   Given coin denominations and an amount, return the fewest number of coins
 *   needed to make that amount. Return -1 if it cannot be made. Unlimited coins
 *   of each denomination are available.
 *
 * Example:
 *   coins = [1,2,5], amount = 11 -> 3  (5 + 5 + 1)
 *   coins = [2], amount = 3      -> -1
 *
 * Approach (bottom-up DP):
 *   dp[a] = minimum coins needed to make amount a. Base case dp[0] = 0. For
 *   every amount a from 1 to amount, try each coin c: if we use coin c, we need
 *   1 + dp[a - c] coins. Take the minimum across all coins. Unreachable amounts
 *   stay at "infinity" (amount + 1 sentinel).
 *
 * Complexity:
 *   Time  O(amount * numberOfCoins), Space O(amount).
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // sentinel = "impossible"
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (coin <= a) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(coinChange(new int[]{2}, 3));        // -1
        System.out.println(coinChange(new int[]{1}, 0));        // 0
    }
}
