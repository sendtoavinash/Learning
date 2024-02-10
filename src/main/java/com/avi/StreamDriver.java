package com.avi;

import java.util.*;

public class StreamDriver {

    public static void main(String[] args) {

        ///////////////////////list of integers, separate odd and even numbers

//        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
//        Map<Boolean, List<Integer>> oddEvenNumbersMap = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
//        System.out.println(oddEvenNumbersMap);
//        System.out.println(oddEvenNumbersMap.get(true));
//        System.out.println(oddEvenNumbersMap.get(false));

        //////////////////remove duplicate elements from a list using Java 8 streams

//        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
//
//        System.out.println(listOfStrings.stream().distinct().collect(Collectors.toList()));
//
//        System.out.println(listOfStrings.stream().collect(Collectors.toSet()));
//
//        System.out.println(new HashSet<>(listOfStrings));

        /////////////find frequency of each character in a string

//        String inputString = "Java Concept Of The Day";
//
//        Map<Character, Long> charCountMap =
//                inputString.chars()
//                        .mapToObj(c -> (char) c)
//                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        System.out.println(charCountMap);

        //////////frequency of each element in an array or a list

//        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
//
//        Map<String, Long> stationeryCountMap = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        System.out.println(stationeryCountMap);
//        ////////////Print the repeating items in list
//        stationeryCountMap.forEach((key, value) -> {
//            if (value > 1) {
//                System.out.println(format("key: %s, value: %s", key, value));
//            }
//        });

        //////////////list of integers, print the numbers which are multiples of 5

//        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//
//        listOfIntegers.stream().filter(i->i%5==0).forEach(System.out::println);

        /////////////Sort a HashMap based on values

//        Map<String, Integer> map = new HashMap<>();
//        map.put("a", 3);
//        map.put("b", 1);
//        map.put("c", 2);
//
////        LinkedHashMap<String, Integer> sortedMap = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
////                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
////        System.out.println(sortedMap);
//
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);


        ////////////find all the Integer start from 1

//        List<Integer> list = Arrays.asList(11, 56, 110, 111, 86, 19);
//
//        List<String> newList = list.stream().map(e -> e + "").filter(e -> e.startsWith("1")).toList();
//
//        System.out.println(newList);

        ////////////sort an array in decresing order distinct element

//        int[] arr = {1, 3, 6, 4, 1, 2};
//        List<Integer> UniqueNumbers = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).toList();
//        System.out.println(UniqueNumbers);

        ///////all elements having same characters

        String[] arr = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        //        contains same character
        //         [epam, pame, aepm] [java, ajav] [abcd, dcba]

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String word : arr) {
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String sortedWord = new String(c);

            map.putIfAbsent(sortedWord, new ArrayList<>());

            map.get(sortedWord).add(word);
        }
        System.out.println(new ArrayList<>(map.values()));

        ////

    }
}
