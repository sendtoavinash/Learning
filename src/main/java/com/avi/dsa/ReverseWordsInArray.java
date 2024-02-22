package com.avi.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInArray {
    public static void main(String[] args) {
        System.out.println(reversedWords("Java Concept Of The Day"));
    }

    public static String reversedWords(String x) {
        String[] wordArray = x.split(" ");

//        String reversedStr = IntStream.rangeClosed(1, wordArray.length).mapToObj(i -> wordArray[wordArray.length - i]).map(word -> new StringBuffer(word)).collect(Collectors.joining(" "));

        List<String> revers = Arrays.stream(x.split(" ")).filter(ele -> !ele.isBlank()).map(String::trim).toList();
        Collections.reverse(revers);
        String reversedStr = revers.stream().collect(Collectors.joining(" "));

        return reversedStr;


    }
}
