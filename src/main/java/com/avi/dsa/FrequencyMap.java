package com.avi.dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyMap {

    public static void main(String[] args) {
        int[] v = {11 ,13, 3, 14, 17, 3, 7, 9, 1, 11, 9, 15, 5, 2, 2, 3 };

        System.out.println(Arrays.toString(getFrequencies(v)));
    }

    public static int[] getFrequencies(int[] v) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            if (map.containsKey(v[i])) {
                map.put(v[i], map.get(v[i]) + 1);
            } else {
                map.put(v[i], 1);
            }
        }

        result[0] = map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        result[1] = map.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();

        return result;
    }
}
