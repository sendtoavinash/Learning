package com.avi.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDriver {

    public static void main(String[] args) {

        ///////////////////////list of integers, separate odd and even numbers

        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        Map<Boolean, List<Integer>> oddEvenNumbersMap = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(oddEvenNumbersMap);
        System.out.println(oddEvenNumbersMap.get(true));
        System.out.println(oddEvenNumbersMap.get(false));

        //////////////////remove duplicate elements from a list using Java 8 streams

     /*   List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

        System.out.println(listOfStrings.stream().distinct().toList());

        System.out.println(listOfStrings.stream().collect(Collectors.toSet()));

        System.out.println(new HashSet<>(listOfStrings));  */

        /////////////find frequency of each character in a string

     /*   String inputString = "Java Concept Of The Day";

        Map<Character, Long> charCountMap = inputString.chars().mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(charCountMap); */

        //////////frequency of each element in an array or a list

     /*   List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");

        Map<String, Long> stationeryCountMap = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(stationeryCountMap);
        ////////////Print the repeating items in list
        stationeryCountMap.forEach((key, value) -> {
            if (value > 1) {
                System.out.println(format("key: %s, value: %s", key, value));
            }
        }); */

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
//        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
//
//        System.out.println(map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue());

        ///////////find all the Integer start from 1

        /*List<Integer> list = Arrays.asList(11, 56, 110, 111, 86, 19);

        List<String> newList = list.stream().map(e -> e + "").filter(e -> e.startsWith("1")).toList();

        System.out.println(newList);*/

        ////////////sort an array in decresing order distinct element
        /*  int[] arr = {1, 3, 6, 4, 1, 2};

        List<Integer> UniqueNumbers = Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).toList();

        System.out.println(UniqueNumbers);  */

        ///////all elements having same characters

       /* String[] arr = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
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
        System.out.println(new ArrayList<>(map.values())); */

        /////////Given a list of integers, find maximum and minimum of those numbers?

      /*  List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        List<Integer> newList = listOfIntegers.stream().sorted().toList();

        System.out.println("Min:-" + newList.get(0) + " Max:-" + newList.get(newList.size() - 1));  */

        ///////////How do you merge two unsorted arrays into single sorted array using Java 8 streams

      /*  int[] a = {4, 2, 7, 1};
        int[] b = {8, 3, 9, 5};

        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();

        System.out.println(Arrays.toString(c));  */

        /////////////How do you get three maximum numbers and three minimum numbers from the given list of integers?

     /*   List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("3 Minimun numbers");
        listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);
        System.out.println("3 Maximun numbers");
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);  */

        ////////////Java 8 program to check if two strings are anagrams or not

     /*   String s1 = "RaceCar";
        String s2 = "CarRace";

        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

        if (s1.equals(s2))
            System.out.println("Valid Anagram");
        else
            System.out.println("Not an Anagram");  */

        ///////////////Find sum of all digits of a number in Java 8

     /*   int i = 15623;

        Integer sum = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();

        System.out.println(sum);  */

        ////////////Find second largest number in an integer array?

     /*   List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        System.out.println(listOfIntegers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get()); */

        //////////// Given a list of strings, sort them according to increasing order of their length?

    /*    List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);  */

        /////////// Given an integer array, find sum and average of all elements?

     /*   int[] a = {45, 12, 56, 15, 24, 75, 31, 89};

        System.out.println(Arrays.stream(a).sum());

        System.out.println(Arrays.stream(a).average().getAsDouble());  */

        /////////// How do you find common elements between two arrays?

//        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
//
//        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
//
//        list1.stream().filter(list2::contains).forEach(System.out::println);

        ////////// Reverse each word of a string using Java 8 streams?

//        String str = "Java Concept Of The Day";
//
//        String reversedStr = Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
//
//        System.out.println(reversedStr);

        ///////// How do you find sum of first 10 natural numbers?

      /*  int sum = IntStream.range(1, 11).sum();
        System.out.println(sum);  */

        //////////// Reverse an integer array
     /*   int[] array = {5, 1, 7, 3, 9, 6};

        int[] reversedArray = IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();

        System.out.println(Arrays.toString(reversedArray));   */

        //////////// Print first 10 even numbers

//        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);

        /////////// How do you find the most repeated element in an array?

//        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
//
//        Map<String, Long> elementCountMap = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        Map.Entry<String, Long> mostFrequentElement = elementCountMap.entrySet().stream().max(Map.Entry.comparingByValue()).get();
//
//        System.out.println("Most Frequent Element : " + mostFrequentElement.getKey());
//
//        System.out.println("Count : " + mostFrequentElement.getValue());

        //////////// Palindrome program using Java 8 streams

    /*    String str = "ROTATOR";

        boolean isItPalindrome = IntStream.range(0, str.length() / 2).noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));

        System.out.println(isItPalindrome);   */

        //////////// Given a list of strings, find out those strings which start with a number?

      /*  List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");

        listOfStrings.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);  */

        //////////// How do you extract duplicate elements from an array?

//        List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
//
//        Set<Integer> uniqueSetOfIntegers = new HashSet<>();
//
//        Set<Integer> duplicates = listOfIntegers.stream().filter(i -> !uniqueSetOfIntegers.add(i)).collect(Collectors.toSet());
//
//        System.out.println(duplicates);

        /////////// Print duplicate characters in a string?

//        String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
//
//        Set<String> uniqueChars = new HashSet<>();
//
//        Set<String> duplicateChars =
//                Arrays.stream(inputString.split("")).filter(ch -> !uniqueChars.add(ch)).collect(Collectors.toSet());
//
//        System.out.println(duplicateChars);

        //////////// Fibonacci series java 8

//        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
//                .limit(10)
//                .map(f -> f[0])
//                .forEach(i -> System.out.print(i + " "));

        ///////// First 10 odd numbers

//        Stream.iterate(new int[]{1, 3}, f -> new int[]{f[1], f[1] + 2})
//                .limit(10)
//                .map(f -> f[0])
//                .forEach(i -> System.out.print(i + " "));

        ///////////// How do you get last element of an array?

//        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
//
//        String lastElement = listOfStrings.stream().skip(listOfStrings.size()-1 ).findFirst().get();
//
//        System.out.println(lastElement);

        //////////////  Find the age of a person in years if the birthday has given?

//        LocalDate birthDay = LocalDate.of(1985, 01, 23);
//        LocalDate today = LocalDate.now();
//
//        System.out.println(ChronoUnit.YEARS.between(birthDay, today));

        ////////// Reverse each word of a string using Java 8 streams?

//        String str = "Java Concept Of The Day";
//
//        String[] wordArray = str.split(" ");
//
//        String reversedStr = IntStream.rangeClosed(1, wordArray.length).mapToObj(i -> wordArray[wordArray.length - i]).map(word -> new StringBuffer(word)).collect(Collectors.joining(" "));
//
//        System.out.println(reversedStr);



    }


}

