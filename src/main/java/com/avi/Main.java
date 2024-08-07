package com.avi;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, Integer> map = currencyCount(20, new HashMap<Integer, Integer>());

        map.entrySet().stream().forEach(i -> {
            System.out.println(i.getKey() + " = " + i.getValue());
        });

    }

    static Map<Integer, Integer> currencyCount(Integer amt, Map<Integer, Integer> result) {
        Integer denomination = 0;
        Integer balance = amt;

        if (!result.containsKey(5)) {
            denomination = 5;
        } else if (!result.containsKey(2)) {
            denomination = 2;
        } else {
            denomination = 1;
        }
        Integer occurrence = balance / denomination ;

        while (balance > 0) {
            balance = balance - denomination * occurrence;
            result.put(denomination, occurrence);
            currencyCount(balance, result);

        }
        return result;
    }

}
