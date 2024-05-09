package com.avi.dsa;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseString {


    public static void main(String[] args) {
        System.out.println(reverseUsingStringBuilder("avinash"));
    }

    public static String reverseUsingStringBuilder(String input) {
        if (input == null) {
            return null;
        }
        StringBuilder output = new StringBuilder(input).reverse();
        return output.toString();
    }

    public static String reverseUsingStreamOfMethod(String str) {
        if (str == null) {
            return null;
        }
        return Stream.of(str)
                .map(string -> new StringBuilder(string).reverse())
                .collect(Collectors.joining());
    }

    public static String reverseUsingIntStreamRangeMethod(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        return IntStream.range(0, str.length())
                .mapToObj(i -> charArray[str.length() - i - 1])
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
