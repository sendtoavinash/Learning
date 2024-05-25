package com.avi;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Alpha", "George");

        List<Person> pList = new ArrayList<>();

        pList.add(new Person("Avi",29));
        pList.add(new Person("ravi",35));
        pList.add(new Person("ritesh",32));

        pList.stream().sorted(Comparator.comparingInt(Person::getAge)).toList();

    }
}
