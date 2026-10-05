package com.avi.dsa2.array;

/**
 * Blind 75 - Array #2: Best Time to Buy and Sell Stock
 * ------------------------------------------------------------------
 * Problem:
 *   prices[i] is the price of a stock on day i. You may complete at most one
 *   transaction (buy once, sell once, on a later day). Return the maximum
 *   profit. If no profit is possible return 0.
 *
 * Example:
 *   prices = [7,1,5,3,6,4] -> 5  (buy at 1 on day 1, sell at 6 on day 4)
 *   prices = [7,6,4,3,1]   -> 0  (prices only fall, so do nothing)
 *
 * Approach (track running minimum):
 *   To sell on day i for maximum profit we want to have bought on the cheapest
 *   day before i. So we sweep left to right keeping the smallest price seen so
 *   far (minPrice). For each day, the best profit if we sell today is
 *   price - minPrice; we keep the maximum of those.
 *
 * Complexity:
 *   Time  O(n) - one pass.
 *   Space O(1) - only two scalars.
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;              // cheaper day to buy
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;  // better day to sell
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
    }
}
