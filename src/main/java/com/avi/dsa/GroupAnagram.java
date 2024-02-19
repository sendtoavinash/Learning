package com.avi.dsa;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {

        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("GroupAnagram:- " + getGroupAnagram(arr));
    }

    public static List<List<String>> getGroupAnagram(String[] arrs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : arrs) {

            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sortedWord = new String(charArr);

            map.putIfAbsent(sortedWord, new ArrayList<>());

            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }

}
