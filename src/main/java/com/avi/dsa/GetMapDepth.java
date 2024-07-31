package com.avi.dsa;

import java.util.HashMap;
import java.util.Map;

public class GetMapDepth {

    public static void main(String[] args) {
        Map<String, String> data = new HashMap<>();
        data.put("A", "C");
        data.put("B", "C");
        data.put("C", "F");
        data.put("D", "E");
        data.put("E", "F");
        data.put("F", "G");

        Map<String, Integer> output = new HashMap<>();
        for (String key : data.keySet()) {
            output.put(key, getDepth(key, data));
        }

        System.out.println(output);
    }

    private static int getDepth(String key, Map<String, String> data) {
        int depth = 0;
        while (data.containsKey(key)) {
            key = data.get(key);
            depth++;
        }
        return depth;
    }

}

