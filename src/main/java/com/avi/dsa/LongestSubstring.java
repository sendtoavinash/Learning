package com.avi.dsa;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0, l = 0, r = 0;
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            } else {
                set.add(s.charAt(r));
                r++;
                result = Math.max(result, set.size());
            }
        }
        return result;
    }

}
