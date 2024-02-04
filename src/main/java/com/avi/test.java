package com.avi;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class test {

    public static void main(String[] args) {
        System.out.println(new Date().getTime());

        List<String> list = Arrays.asList("pen", "pinneapple", "apple", "pen");
        Map<String, Long> countMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap);

        countMap.forEach((key, value) -> {
            if (value > 1) {
                System.out.println(format("key: %s, value: %s", key, value));
            }
        });
    }
}
