package com.avi.dsa;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWordsInArray {
    public static void main(String[] args) {
        System.out.println(reversedWords("Java Concept Of The Day"));
    }

    public static String reversedWords(String x) {
        String[] wordArray = x.split(" ");

        String reversedStr = IntStream.rangeClosed(1, wordArray.length).mapToObj(i -> wordArray[wordArray.length - i]).map(word -> new StringBuffer(word)).collect(Collectors.joining(" "));

        return reversedStr;


    }
}
