package com.avi.dsa;

public class SellStock {

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(price));
    }

    public static int maxProfit(int[] prices) {
        int l = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < l) {
                l = prices[i];
            }
            profit = prices[i] - l;
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

//    public static int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (maxProfit < prices[j] - prices[i]) {
//                    maxProfit = prices[j] - prices[i];
//                }
//            }
//        }
//        return maxProfit;
//    }

//    public int maxProfit(int[] prices) {
//        int profit = 0;
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            int l = prices[i];
//            for (int j = prices.length - 1; j >= 0; j--) {
//                int r = prices[j];
//                if (i < j) {
//                    profit = r - l;
//                }
//                if (profit > maxProfit) {
//                    maxProfit = profit;
//                }
//            }
//        }
//        return maxProfit;
//    }

}
