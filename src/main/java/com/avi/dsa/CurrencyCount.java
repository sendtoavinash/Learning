package com.avi.dsa;

import java.util.HashMap;
import java.util.Map;

public class CurrencyCount {

    public static void main(String[] args) {
        Map<Integer, Integer> map = minCoins(20);

        map.entrySet().stream().forEach(i -> {
            System.out.println(i.getKey() + " = " + i.getValue());
        });
    }

    public static Map<Integer, Integer> minCoins(int amount) {

        int ones = 1;
        int twos = 1;
        int fives = 1;
        amount -= 8;

        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be at least 8 to use all coins at least once.");
        }

        fives += amount / 5;
        amount %= 5;

        twos += amount / 2;
        amount %= 2;

        ones += amount;

        Map<Integer, Integer> result = new HashMap<>();
        result.put(1, ones);
        result.put(2, twos);
        result.put(5, fives);

        return result;
    }
}
