package com.avi;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));

    }

    public static Boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        Arrays.sort(charArrayS);
        Arrays.sort(charArrayT);
        return Arrays.equals(charArrayS, charArrayT);
    }

//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] charCountS = new int[26];
//        int[] charCountT = new int[26];
//        for (char c : s.toCharArray()) {
//            charCountS[c - 'a']++;
//        }
//        for (char c : t.toCharArray()) {
//            charCountT[c - 'a']++;
//        }
//        return Arrays.equals(charCountS, charCountT);
//    }

//    public static Boolean isAnagram(String s, String t) {
//        if (s.length() != t.length())
//            return false;
//
//        Map<Character, Integer> count = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            count.put(ch, count.getOrDefault(ch, 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            char ch = t.charAt(i);
//
//            if (count.get(ch) == 0) {
//                return false;
//            } else if (count.get(ch) == 1) {
//                count.remove(ch);
//            } else {
//                count.put(ch, count.get(ch) - 1);
//            }
//        }
//        return count.size() == 0;
//    }

}
