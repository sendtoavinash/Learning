package com.avi;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ModifyVariableName {

    public static void main(String[] args) {
        System.out.println(modifyVariableName("avinash_upadHyay_is"));

        AtomicInteger index = new AtomicInteger(0);
        System.out.println(Arrays.asList("amit_binjola_java8_test".split("_")).stream()
                .map((c) -> index.getAndIncrement() == 0 ? c.toLowerCase()
                        : (Character.toUpperCase(c.charAt(0)) + c.substring(1, c.length()).toLowerCase()))
                .collect(Collectors.joining("")));

    }


    public static String modifyVariableName(String input) {

        String result = "";
        int i = 0;
        for (String temp : input.split("_")) {
            if (i == 0) {
                result += temp.trim();
                i++;
            } else {
                result += (Character.toUpperCase(temp.charAt(0)) + temp.substring(1).toLowerCase());
            }
        }
        return result;
    }
}
